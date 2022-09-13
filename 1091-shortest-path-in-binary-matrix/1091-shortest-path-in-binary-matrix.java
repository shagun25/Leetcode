class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n =grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        if(grid[0][0]==0) q.add(new int[]{0,0});
        else return -1;
        int min=0;
        int dir[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,-1},{-1,1}};
        while(!q.isEmpty()){
            int sz= q.size();
            for(int i=0;i<sz;i++){
                int[] curr =  q.poll();
                if(curr[0]==n-1 && curr[1]==m-1) return min+1;
                for(int[] d: dir){
                    int r = curr[0]+d[0];
                    int c = curr[1]+d[1];
                    if(r>=0 && c>=0 && r<=m-1 && c<=n-1 && grid[r][c]==0){
                        q.add(new int[]{r,c});
                        grid[r][c]=1;
                    }
                }
            }
            min++;
        }
        return -1;
    }
}