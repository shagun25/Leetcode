class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length,m=grid[0].length;
        boolean visited[][] = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        boolean found=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&&!visited[i][j]){
                    DFS(grid,visited,queue,i,j,n,m);
                    found=true;
                }
              if(found==true) break;
            }
            if(found==true) break;
        }
        int dir[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int level=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size--!=0){
                int pair[] = queue.poll();
                for(int d[] : dir){
                    int i= d[0]+pair[0];
                    int j= d[1]+pair[1];
                    if(i<0 || i>=n || j<0 || j>=m || visited[i][j]) continue;
                    if(grid[i][j]==1) return level;
                    visited[i][j]=true;
                    queue.add(new int[]{i,j});
                }
            }
           level++;
        }
        return -1;
    }
    void DFS(int[][] grid,boolean visited[][],Queue<int[]> queue,int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0|| visited[i][j]) return;
        visited[i][j]=true;
        queue.add(new int[]{i,j});
        DFS(grid,visited,queue,i+1,j,n,m);
        DFS(grid,visited,queue,i-1,j,n,m);
        DFS(grid,visited,queue,i,j+1,n,m);
        DFS(grid,visited,queue,i,j-1,n,m);
    }
}