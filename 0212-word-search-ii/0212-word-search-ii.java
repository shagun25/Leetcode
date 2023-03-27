class TrieNode{
    TrieNode links[];
    String wrd;
    TrieNode(){
        links = new TrieNode[26];
        wrd=null;
    }
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    void put(char ch,TrieNode node){
        links[ch-'a']=node;
    }
    TrieNode get(char ch){
        return links[ch-'a'];
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
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String str : words){
            trie.insert(str);
        }
        TrieNode node = trie.root;
        List<String> ans= new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char ch = board[i][j];
                DFS(board,node,i,j,ans);
            }
        }
        return ans;
    }
   void DFS(char[][] board, TrieNode node, int i,int j,List<String> ans){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='#' || !node.containsKey(board[i][j])) return;
        char c = board[i][j];
        node = node.get(c);
        if(node.getWrd()!=null){
            ans.add(node.wrd);
            node.setWrd(null);
        }
       
        board[i][j]='#';
        DFS(board,node,i+1,j,ans);
        DFS(board,node,i-1,j,ans);
        DFS(board,node,i,j+1,ans);
        DFS(board,node,i,j-1,ans);
        board[i][j]=c;
    }
}