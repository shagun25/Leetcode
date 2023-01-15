class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int[] edge : edges) {
            adj.computeIfAbsent(edge[0],x-> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1],x-> new ArrayList<>()).add(edge[0]);
        }
        
        long res = 0;
        Map<String,Long> memPathSum = new HashMap<>();
        for(Map.Entry<Integer,List<Integer>> entry : adj.entrySet()) {
            int root = entry.getKey();
            long max = maxPriceSum(root,-1,adj,price,memPathSum);
            long min = (long) price[root];
            res = Math.max(res,max-min);
        }
        return res;
    }
    
    private long maxPriceSum(int node,int parent,Map<Integer,List<Integer>> adj,int[] price,Map<String,Long> memPathSum) {
        if(!adj.containsKey(node)) return 0;
        
        long sum = 0;
        for(int child : adj.get(node)) {
            if(child == parent) continue;
            long childPathSum;
            if(memPathSum.containsKey(child+"#"+node))
                childPathSum = memPathSum.get(child+"#"+node);
            else {
                childPathSum = maxPriceSum(child,node,adj,price,memPathSum);
                memPathSum.put(child+"#"+node,childPathSum);
            }
               
            sum = Math.max(childPathSum,sum);
        }
        sum += price[node];
        return sum;
    }
}