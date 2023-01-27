class Solution {
    private static Node root;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words == null || words.length == 0)
            return new ArrayList<>();
        root = new Node();
        buildTrie(words);
        List<String> res = new LinkedList<>();
        for(String word : words){
            if(isConcatenated(word,0,0)) res.add(word);
        }
        return res;
    }
    boolean isConcatenated(String word,int index,int count){
        if(index==word.length()) return count>=2;
        Node ptr = root;
        for(int i=index;i<word.length();i++){
            if(ptr.children[word.charAt(i) - 'a']==null) return false;
            ptr = ptr.children[word.charAt(i) - 'a'];
            
            if (ptr.isEnd)
                if (isConcatenated(word, i + 1, count + 1))
                    return true;
        }
        return false;
    }
    
    void buildTrie(String[] words){
        Node ptr;
        for(String word : words){
            ptr = root;
            for(char ch : word.toCharArray()){
                int index = ch-'a';
                if(ptr.children[index]==null){
                    ptr.children[index] = new Node();
                }
                ptr = ptr.children[index];
            }
            ptr.isEnd = true;
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