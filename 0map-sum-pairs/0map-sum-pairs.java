class TrieNode{
    TrieNode links[];
    int val;
    TrieNode(){
        links = new TrieNode[26];
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
    public void setVal(int v){
        val=v;
    }
    public int getVal(){
        return val;
    }
}
class MapSum {
    TrieNode root;
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode node = root;
        for(char ch : key.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setVal(val);
    }
    
    public int sum(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            if(!node.containsKey(ch)){
                return 0;
            }
            node = node.get(ch);
        }
        return DFS(node);
    }
    int DFS(TrieNode node){
        int sum = 0;
        for(char ch = 'a'; ch <= 'z'; ++ch){
            if(node.containsKey(ch) == true){
                sum += DFS(node.get(ch));
            }
        }
        
        return sum + node.getVal();
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */