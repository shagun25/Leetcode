class Solution {
     Node root;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res= new LinkedList<>();
        if(words==null || words.length==0) return res;
        root = new Node();
        buildTrie(words);
        for(String word : words){
            if(isConcatenated(word,0,0)) res.add(word);
        }
        return res;
    }
    boolean isConcatenated(String word, int index, int count){
        if(index==word.length()) return count>=2;
        Node ptr = root;
        for(int i = index;i<word.length();i++){
            if(ptr.children[word.charAt(i)-'a']==null) return false;
            ptr = ptr.children[word.charAt(i)-'a'];
            if(ptr.isEnd){
                if(isConcatenated(word,i+1,count+1)) return true;
            }
        }
        return false;
    }
    void buildTrie(String[] words){
        Node ptr;
        for(String word : words){
            ptr = root;
            for(char ch : word.toCharArray()){
                if(ptr.children[ch-'a']==null) ptr.children[ch-'a'] = new Node();
                ptr=ptr.children[ch-'a'];
            }
            ptr.isEnd=true;
        }
    }
    class Node{
        Node[] children;
        boolean isEnd;
        Node(){
            children = new Node[26];
            isEnd = false;
        }
    }
}