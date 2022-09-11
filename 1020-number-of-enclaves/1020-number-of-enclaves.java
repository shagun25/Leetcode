class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            DFSMarking(grid,i,0);
            DFSMarking(grid,i,m-1);
        }
        for(int j=0;j<m;j++){
            DFSMarking(grid,0,j);
            DFSMarking(grid,n-1,j);
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    grid[i][j]=1;
                }else if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    void DFSMarking(int[][] grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=1) return;
        grid[i][j]=2;
        DFSMarking(grid,i+1,j);
        DFSMarking(grid,i-1,j);
        DFSMarking(grid,i,j+1);
        DFSMarking(grid,i,j-1);
    }
}