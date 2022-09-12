class Solution {
    public int maxDistance(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int n = mat.length,m=mat[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    q.add(new int[]{i,j});
                    visited[i][j]=true;             
                }
            }
        }
        int dir[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int level=-1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int curr[] = q.poll();
            for(int i=0;i<4;i++){
                int x = curr[0]+dir[i][0];
                int y = curr[1]+dir[i][1];
                if(x<0 || x>=n || y<0 || y>=m || visited[x][y]) continue;
                q.add(new int[]{x,y});
                visited[x][y]=true;
            }
            }
            level++;
            
        }
        
        return level<=0?-1:level;
    }
}