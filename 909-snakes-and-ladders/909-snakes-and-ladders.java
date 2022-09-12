class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean visited[][] = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[n-1][0]=true;
        int steps=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int x = queue.poll();
                if(x==n*n) return steps;
                for(int k=1;k<=6;k++){
                    if(k+x>n*n) continue;
                    int pos[] = findCoordinates(k+x,n);
                    int row = pos[0],col = pos[1];
                    if(visited[row][col]==true) continue;
                    visited[row][col]=true;
                    if(board[row][col]==-1) queue.add(k+x);
                    else queue.add(board[row][col]);
                }
            }
            steps++;
        }
        return -1;
    }
    int[] findCoordinates(int curr,int n){
        int r = n - (curr-1)/n - 1;
        int c = (curr-1) % n;
        if(r%2==n%2) return new int[]{r,n-1-c};
        else return new int[]{r,c};
    }
}