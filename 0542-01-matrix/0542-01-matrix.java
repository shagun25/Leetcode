class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                   q.add(new int[]{i,j});
                    vis[i][j]=true;
                }
            }
        }
        int dir[][] = new int[][]{{1,0},{0,-1},{-1,0},{0,1}};
        while(!q.isEmpty()){
            int curr[] = q.poll();
            for(int d[] : dir){
                int x = curr[0] + d[0];
                int y = curr[1] + d[1];
                if(x<0 || x>=n || y<0 || y>=m || vis[x][y]) continue;
                mat[x][y] = 1+ mat[curr[0]][curr[1]];
                q.add(new int[]{x,y});
                vis[x][y]=true;
            }
        }
        return mat;
    }
}