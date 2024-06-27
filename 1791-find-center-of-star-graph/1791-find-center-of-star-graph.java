class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int maxElement=0, maxfreq=0;
        for(int i=0;i<edges.length;i++){
            int x = edges[i][0]; 
            int y = edges[i][1]; 
            map.put(x, map.getOrDefault(x,0)+1);    
            map.put(y, map.getOrDefault(y,0)+1);
            if(map.get(x)>maxfreq){
                maxElement = x;
                maxfreq=map.get(x);
            }
            if(map.get(y)>maxfreq){
                maxElement = y;
                maxfreq=map.get(x);
            }
            
        }
        return maxElement;
    }
}

    