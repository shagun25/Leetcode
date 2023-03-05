class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n<=1) return 0;
        
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(arr[i],v-> new ArrayList<Integer>()).add(i);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        int steps=0;
        while(!q.isEmpty()){
            steps++;
            int sz = q.size();
            for(int i=0;i<sz;i++){
                int j = q.poll();
                
                //jump to j-1
                if(j-1>=0 && map.containsKey(arr[j-1])) q.add(j-1);
                
                //jump to j+1
                if(j+1<n && map.containsKey(arr[j+1])){
                    if(j+1==n-1) return steps;
                     q.add(j+1);
                }
                
                 //jump to k -> arr[j]==arr[k]
                if(map.containsKey(arr[j])){
                    for(int k :map.get(arr[j])){
                        if(k!=j){
                            if(k==n-1) return steps;
                            q.add(k);
                        }
                    }
                }
                map.remove(arr[j]);
            }
        }
        return steps;
    }
}