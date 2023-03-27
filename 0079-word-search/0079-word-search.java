class TrieNode{
    TrieNode links[];
    String wrd;
    TrieNode(){
        links = new TrieNode[127];
        wrd=null;
    }
    boolean containsKey(char ch){
        return links[ch-'A']!=null;
    }
    void put(char ch,TrieNode node){
        links[ch-'A']=node;
    }
    TrieNode get(char ch){
        return links[ch-'A'];
    }
    void setWrd(String word){
        wrd=word;
    }
    String getWrd(){
        return wrd;
    }
}
class Trie{
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    void insert(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch,new TrieNode());
            }
            node = node.get(ch);
        }
        node.setWrd(word);
    }
}
class Solution {
    boolean flag=false;
   void DFS(char[][] board, TrieNode node, int i,int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='#' || !node.containsKey(board[i][j])) return;
        char c = board[i][j];
      // System.out.print(c+" ");
        node = node.get(c);
        if(node.getWrd()!=null){
            node.setWrd(null);
            flag=true;
            return;
        }
       
        board[i][j]='#';
        DFS(board,node,i+1,j);
        DFS(board,node,i-1,j);
        DFS(board,node,i,j+1);
        DFS(board,node,i,j-1);
        board[i][j]=c;
    }
    public boolean exist(char[][] board, String word) {
        Trie trie = new Trie();
        trie.insert(word);
        
        TrieNode node = trie.root;
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                DFS(board,node,i,j);
            }
        }
        return flag;
    }
}