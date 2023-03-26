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
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<>();
        int ind=0;
        for(int query[] : queries){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(query[1]);
            list.add(query[0]);
            list.add(ind);
            ind++;
            offlineQueries.add(list);
        }
        Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>> () {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0).compareTo(b.get(0));
            }
        });
     
        int n = nums.length;
        int m = queries.length;
        int ans[] = new int[m];
        Trie trie = new Trie();
        ind=0;
        for(ArrayList<Integer> offlineQuery: offlineQueries){
            while(ind<n && nums[ind]<=offlineQuery.get(0)){
                trie.insert(nums[ind]);
                ind++;
            }
            int queryIdx = offlineQuery.get(2);
            if(ind!=0) ans[queryIdx] = trie.getMax(offlineQuery.get(1));
            else ans[queryIdx] = -1;
        }
        return ans;
    }
}