class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length,m=grid2[0].length,count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1) {
                     System.out.println(i+" "+j);
                    if(DFS(grid1,grid2,i,j,n,m)) count++;
                }
            }
        }
        return count;
    }
    boolean DFS(int[][] grid1, int[][] grid2,int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m || grid2[i][j]==0) return true;
        grid2[i][j]=0;
        boolean l = DFS(grid1,grid2,i+1,j,n,m);
        boolean r = DFS(grid1,grid2,i-1,j,n,m);
        boolean lr = DFS(grid1,grid2,i,j+1,n,m);
        boolean rl = DFS(grid1,grid2,i,j-1,n,m);
        return l && r && lr && rl && grid1[i][j]==1;
    }
}