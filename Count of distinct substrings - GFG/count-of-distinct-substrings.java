//{ Driver Code Starts
import java.util.*;

class suffix
{
     int index;  
    int rank[] = new int[2];
}

class UniqueSubStr
{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            GfG g = new GfG();
            System.out.println(g.countDistinctSubstring(st));
        }
    }
}
// } Driver Code Ends


/*You are required to complete this method */
class TrieNode{
    TrieNode links[];
    TrieNode(){
        links = new TrieNode[26];
    }
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    TrieNode get(char ch){
        return links[ch-'a'];
    }
    void put(char ch, TrieNode node){
        links[ch-'a'] = node;
    }
}
class Trie{
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    public int insert(String word) {
        TrieNode node = root;
        int cnt=0;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch, new TrieNode());
                cnt++;
            }
            node = node.get(ch);
        }
        return cnt;
    }
}
class GfG
{
   public static int countDistinctSubstring(String st)
   {
       Trie trie = new Trie();
       int n = st.length();
       int count=0;
       for(int i=0;i<n;i++){
               count+=trie.insert(st.substring(i));
       }
       return count+1;
   }
}