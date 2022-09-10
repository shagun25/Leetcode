class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length,m=maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];
        visited[entrance[0]][entrance[1]] = true;
        queue.add(new int[]{entrance[0],entrance[1]});
        int dir[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int level=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size--!=0){
                int pair[] = queue.poll();
                System.out.println(pair[0]+" "+pair[1]);
                for(int d[] : dir){
                    int i= d[0]+pair[0];
                    int j= d[1]+pair[1];
                    if(i<0 || i>=n || j<0 || j>=m || maze[i][j]=='+' || visited[i][j]) continue;
                    if(i==0 || j==0 || i==n-1 || j==m-1) return level+1;
                    queue.add(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
           level++;
        }
        return -1;
    }
}