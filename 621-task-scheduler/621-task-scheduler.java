class Solution {
    public int leastInterval(char[] tasks, int n) {
       HashMap<Character,Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());
        int res=0;
        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int time=0;
            for(int i=0;i<n+1;i++){  
                if(!pq.isEmpty()){
                    temp.add(pq.poll()-1);
                    time++; 
                }
            }
            for(int x:temp) if(x>0) pq.add(x);
            res+=pq.isEmpty()?time:n+1;
        }
        return res;
    }
}