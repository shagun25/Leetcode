class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean vis[][] = new boolean[n][n];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[n-1][0]=true;
        int steps=0;
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-->0){
                int x = q.poll();
                if(x==n*n) return steps;
                for(int k=1;k<=6;k++){
                    if(k+x>n*n) continue;
                    int pos[] = findCoord(k+x,n);
                    int r = pos[0],c=pos[1];
                    if(!vis[r][c]){
                        vis[r][c]=true;
                        if(board[r][c]==-1) q.add(k+x);
                        else q.add(board[r][c]);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    int[] findCoord(int x,int n){
        int r = n- (x-1)/n - 1;
        int c = (x-1) % n;
        if(r%2==n%2) return new int[]{r,n-c-1};
        return new int[]{r,c};
    }
}