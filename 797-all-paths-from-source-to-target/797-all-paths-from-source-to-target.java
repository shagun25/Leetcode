class Solution {
    List<List<Integer>> paths;
     void dfs(int[][] graph,int source,int dest,boolean visited[],ArrayList<Integer> path){
        path.add(source);
         if(source==dest) {
             paths.add(new ArrayList<Integer>(path));
             return;
         }
        
          visited[source]=true;
        for(int u: graph[source]){
            if(!visited[u]){
                dfs(graph,u,dest,visited,path);
                path.remove(path.size()-1);
            }
        }
        visited[source]=false;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        paths = new ArrayList<>();
        boolean visited[] = new boolean[graph.length];
        dfs(graph,0,graph.length-1,visited,new ArrayList<Integer>());
        return paths;
    }
}