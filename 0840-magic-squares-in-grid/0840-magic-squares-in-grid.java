class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        for(int i=0;i<m-2;i++){
            for(int j=0;j<n-2;j++){
                if(isMagicSquare(grid,i,j)) ans++;
            }
        }
        return ans;
    }
    boolean isMagicSquare(int[][] grid, int i, int j){
        boolean seen[] = new boolean[10];
        for(int row=i;row<i+3;row++){
            for(int col=j;col<j+3;col++){
                int num = grid[row][col];
                if(num<1 || num>9)  return false;
                if(seen[num]) return false;
                seen[num]=true;
            }
        }
        int d1 = grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2];
        int d2 = grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j];
        if(d1!=d2) return false;
        int r1 = grid[i][j]+grid[i][j+1]+grid[i][j+2];
        int r2 = grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2];
        int r3 = grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2];
        if(!(r1==d1 && r2==d2 && r3==d2)) return false;
        int c1 = grid[i][j]+grid[i+1][j]+grid[i+2][j];
        int c2 = grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1];
        int c3 = grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2];
        if(!(c1==d1 && c2==d2 && c3==d2)) return false;
        return true;
    }
}