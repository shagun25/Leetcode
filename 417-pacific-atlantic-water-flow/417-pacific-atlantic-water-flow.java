class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new LinkedList<>();
         int n=heights.length,m=heights[0].length;
        boolean[][] atlantic = new boolean[n][m];
        boolean[][] pacific = new boolean[n][m];
      
        for(int i=0;i<n;i++){
            DFSMarking(heights,pacific,Integer.MIN_VALUE,i,0);
            DFSMarking(heights,atlantic,Integer.MIN_VALUE,i,m-1);
        }
         for(int i=0;i<m;i++){
            DFSMarking(heights,pacific,Integer.MIN_VALUE,0,i);
            DFSMarking(heights,atlantic,Integer.MIN_VALUE,n-1,i);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(atlantic[i][j] && pacific[i][j]){
                    ArrayList<Integer> arr = new ArrayList<Integer>();
                    arr.add(i);
                    arr.add(j);
                    res.add(arr);
                }
            }
        }
        return res;
    }
     void DFSMarking(int[][] grid,boolean[][] bool, int height,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || bool[i][j] ||grid[i][j]<height) return;
        bool[i][j]=true;
        DFSMarking(grid,bool,grid[i][j], i + 1, j);
        DFSMarking(grid,bool,grid[i][j], i - 1, j);
        DFSMarking(grid,bool,grid[i][j], i, j + 1);
        DFSMarking(grid,bool,grid[i][j], i, j - 1);
    }
}