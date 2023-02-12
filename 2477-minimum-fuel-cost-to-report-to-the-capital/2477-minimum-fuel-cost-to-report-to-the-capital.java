class Solution {
    long fuel=0;
    long dfs(int node,int parent,Map<Integer,List<Integer>> adj,int seats){
        int representative=1;
        if (!adj.containsKey(node)) {
            return representative;
        }
        for(int child: adj.get(node)){
            if(child!=parent){
                representative+=dfs(child,node,adj,seats);
            }
        }
        if(node!=0){
            fuel+=Math.ceil((double)representative/seats);
        }
        return representative;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int road[] : roads){
            adj.computeIfAbsent(road[0],k->new ArrayList<Integer>()).add(road[1]);
            adj.computeIfAbsent(road[1],k->new ArrayList<Integer>()).add(road[0]);
        }
         dfs(0,-1,adj,seats); 
        return fuel;
    }
}