class Solution {
    // 3 ways to solve
    //     1. Graph Coloring -
    //              BFS
    //              DFS
    //     2. Union Find
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
           if(color[i]==0){
             if(!validColor(graph,color,1,i)) return false;
          }
        }
       
        return true;
    }
    boolean validColor(int[][] graph,int color[],int c,int node){
        if(color[node]!=0) return color[node]==c;
        color[node]=c;
        for(int x:graph[node]){
            if(!validColor(graph,color,-c,x)) return false;
        }
        return true;
    }
}