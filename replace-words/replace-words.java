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

class Solution {
    TrieNode root;
    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    public String search(String word){
         TrieNode node = root;
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            
            if(node.isEnd() == true){
                return word.substring(0, i);
            }
            
            if(node.containsKey(ch) == false){
                return word;
            }
            
            node = node.get(ch);
        }
        
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(int i = 0; i < dictionary.size(); ++i){
            String word = dictionary.get(i);
            insert(word);
        }
        
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < words.length; ++i){
            String word = words[i];
            String prefix = search(word);
            res.append(prefix);
            res.append(" ");
        }
        
        return res.toString().substring(0, res.length() - 1);
    }
 
}