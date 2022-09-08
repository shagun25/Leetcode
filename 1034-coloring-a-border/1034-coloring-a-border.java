class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid,row,col,grid[row][col]);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]<0){
                    grid[i][j]=color;
                }
            }
        }
        return grid;
    }
    void dfs(int[][] grid, int r, int c,int color){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]!=color) return;
        grid[r][c] = -color;
        dfs(grid,r+1,c,color);
        dfs(grid,r-1,c,color);
        dfs(grid,r,c+1,color);
        dfs(grid,r,c-1,color);
        if(r>0 && r<grid.length-1 && c>0 && c<grid[0].length-1 && color==Math.abs(grid[r+1][c]) && color==Math.abs(grid[r-1][c]) && color==Math.abs(grid[r][c+1]) && color==Math.abs(grid[r][c-1])) grid[r][c] = color;
    }
}
