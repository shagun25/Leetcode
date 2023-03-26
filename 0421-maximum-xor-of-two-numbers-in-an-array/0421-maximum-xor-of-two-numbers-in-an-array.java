class TrieNode{
    TrieNode links[];
    TrieNode(){
        links = new TrieNode[2];
    }
    public boolean containsKey(int indx){
        return links[indx]!=null;
    }
    public TrieNode get(int indx){
        return links[indx];
    }
    public void put(int indx, TrieNode node){
        links[indx] = node;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(int num) {
        TrieNode node = root;
        for(int i=31;i>=0;i--){
            int bit = (num>>i)&1;
            if(!node.containsKey(bit)){
                node.put(bit, new TrieNode());
            }
            node = node.get(bit);
        }
    }
    public int getMax(int num){
        TrieNode node = root;
        int maxNum=0;
        for(int i=31;i>=0;i--){
            int bit = (num>>i)&1;
            if(node.containsKey(1-bit)){
                maxNum = maxNum | (1<<i);
                node = node.get(1-bit);
            }
            else{
               node = node.get(bit); 
            }
        }
        return maxNum;
    }
}
class Solution {
    Trie trie = new Trie();
    public int findMaximumXOR(int[] nums) {
        for(int num : nums){
            trie.insert(num);
        }
        int max = -1;
        for(int num : nums){
            max=Math.max(max,trie.getMax(num));
        }
        return max;
    }
}