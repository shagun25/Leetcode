class Solution {
    boolean flag=false;
   void DFS(char[][] board, int i,int j,int ind,String word){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='#' || word.charAt(ind)!=board[i][j]) return;
        char c = board[i][j];
        if(ind==word.length()-1){
            flag=true;
            return;
        }
       
        board[i][j]='#';
        ind++;
        DFS(board,i+1,j,ind,word);
        DFS(board,i-1,j,ind,word);
        DFS(board,i,j+1,ind,word);
        DFS(board,i,j-1,ind,word);
        board[i][j]=c;
    }
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                DFS(board,i,j,0,word);
            }
        }
        return flag;
    }
}