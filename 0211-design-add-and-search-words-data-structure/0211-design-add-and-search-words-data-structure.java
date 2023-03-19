class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        return helper(0,word,node);
    }
    boolean helper(int ind,String word,TrieNode node){
            if(ind==word.length())
                return node.isEnd();
            for(int i=ind;i<word.length();i++){
                if(word.charAt(i)=='.'){
                    for(int j='a';j<='z';j++){
                        if(node.containsKey((char)j)){
                            TrieNode tmp = node;
                            tmp = tmp.get((char)j);
                            if(helper(i+1,word,tmp))
                                return true;
                        }
                    }
                    return false;
                }
                if(!node.containsKey(word.charAt(i)))
                    return false;
                node = node.get(word.charAt(i));
            }
            return node.isEnd();
    }
}
class TrieNode{
    TrieNode links[];
    boolean isEnd;
    TrieNode(){
        links = new TrieNode[26];
        isEnd = false;
    }
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    public TrieNode get(char ch){
        return links[ch-'a'];
    }
    public void put(char ch, TrieNode node){
        links[ch-'a'] = node;
    }
    public void setEnd(){
        isEnd=true;
    }
    public boolean isEnd(){
        return isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */