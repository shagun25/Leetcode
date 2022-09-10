class Solution {
    public int closedIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
                DFSMarking(grid,i,0);
                DFSMarking(grid,i,grid[0].length-1);
        }
        for(int j=0;j<grid[0].length;j++){
                DFSMarking(grid,0,j);
                DFSMarking(grid,grid.length-1,j);
        }
        // for(int i=0;i<grid.length;i++){
        //     for(int j=0;j<grid[0].length;j++){
        //         System.out.print(grid[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0) {
                    DFSMarking(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    void DFSMarking(int[][] grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==1) return;
        grid[i][j]=1;
        DFSMarking(grid,i+1,j);
        DFSMarking(grid,i-1,j);
        DFSMarking(grid,i,j+1);
        DFSMarking(grid,i,j-1);
    }
}