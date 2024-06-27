class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        Map<Integer, ArrayList<Pair<Integer,Integer>>> map = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            map.computeIfAbsent(edges[i][0], key -> new ArrayList<>())
                 .add(new Pair<>(vals[edges[i][1]], edges[i][1]));
            map.computeIfAbsent(edges[i][1], key -> new ArrayList<>())
                 .add(new Pair<>(vals[edges[i][0]], edges[i][0]));
        }
        
        int max=Integer.MIN_VALUE;
        for(int i:vals){
            max=Math.max(max,i);
        }
        for(Map.Entry<Integer, ArrayList<Pair<Integer,Integer>>> entry : map.entrySet()) {
             Integer key = entry.getKey();
             ArrayList<Pair<Integer,Integer>> value = entry.getValue();
             value.sort((a, b) -> b.getKey().compareTo(a.getKey()));
             int sum=vals[key];
             for(int i=0;i<Math.min(k,value.size());i++){
                 if(value.get(i).getKey()>0) sum+=value.get(i).getKey();
             }
            max=Math.max(max,sum);
        }
        return max;
    }
}