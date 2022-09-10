class Solution {
    void dfs(int[][] isConnected,int u,boolean visited[]){
        visited[u]=true;
        for(int j=0;j<isConnected.length;j++){
            if(!visited[j] && isConnected[u][j]==1){
                dfs(isConnected,j,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean visited[] = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected,i,visited);
                count++;
            }
        }
        return count;
    }
}