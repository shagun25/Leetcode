class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // 1. reverse edges
        // 2. indegree[]
        // 3. set and queue store the indegree[] =0;
        // 4. BFS
        // 5. sort the set and return.
        int indegree[] = new int[graph.length];  
        HashMap<Integer,Set<Integer>> map = new HashMap<>();
        for(int i=0;i<graph.length;i++){
            for(int neighbour : graph[i]){
                if(!map.containsKey(neighbour)) map.put(neighbour,new HashSet<Integer>());
                map.get(neighbour).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> res = new HashSet<Integer>();
        for(int i=0;i<graph.length;i++){
            if(indegree[i]==0){
                res.add(i);
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int u = queue.poll();
            res.add(u);
            if(map.containsKey(u)){
                for(int v : map.get(u)){
                   indegree[v]--;
                   if(indegree[v]==0){
                      queue.add(v);
                   }
                }
            }
        }
        List<Integer> result = new ArrayList<Integer>(res);
        Collections.sort(result);
        return result;
    }
}