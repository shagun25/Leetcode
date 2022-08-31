class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] graph = new List[n+1];
        for (int i = 1; i < n+1; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        boolean[] visited = new boolean[n+1]; 
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,1});
        visited[1] = true;
        int steps=0;
        while(!queue.isEmpty() && steps<=t){
            int sz = queue.size();
            while(sz--!=0){
                int[] v = queue.poll();
                int b =0;
                for(int u : graph[v[0]]){
                   if(!visited[u]){
                      b++;
                   }
                }
                if(v[0] == target && (b==0 || steps==t)) return 1.0/v[1];
                for(int u : graph[v[0]]){
                   if(!visited[u]){
                      queue.add(new int[]{u,v[1]*b});
                      visited[u] = true;
                   }
                }
            }
            steps++;
        }
        return 0.0;
    }
}