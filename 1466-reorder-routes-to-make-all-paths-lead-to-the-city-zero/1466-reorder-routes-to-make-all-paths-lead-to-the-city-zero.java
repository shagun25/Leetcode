class Solution {
    int change=0;
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++) adjList.add(new ArrayList<int[]>());
        for(int connect[] : connections){
            adjList.get(connect[0]).add(new int[]{connect[1],1});
            adjList.get(connect[1]).add(new int[]{connect[0],0});
        }
        boolean visited[] = new boolean[n];
        dfs(adjList,visited,0);
        return change;
    }
    void dfs(ArrayList<ArrayList<int[]>> adjList,boolean visited[],int from){
        visited[from]=true;
        for(int curr[] : adjList.get(from)){
            if(!visited[curr[0]]){
                change+=curr[1];
                dfs(adjList,visited,curr[0]);
            }
        }
    }
}