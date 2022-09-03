class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n%2!=0) return new int[0];
        int i=0;
        int res[] = new int[n/2];
        Map<Integer,Integer> map = new TreeMap<>();
        for(int x:changed){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(int x: map.keySet()){
            if(map.get(x)>map.getOrDefault(x+x,0)) return new int[0];
            else{
                for(int j=0;j<map.get(x);j++){
                    res[i++]=x;
                    map.put(x+x,map.get(x+x)-1);
                }
            }
        }
        return res;
    }
}