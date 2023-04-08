/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    void dfs(Node node,Node copy,Node vis[]){
        vis[copy.val]=copy;
        for(Node neigh: node.neighbors){
            if(vis[neigh.val]==null){
                Node newNode = new Node(neigh.val);
                copy.neighbors.add(newNode);
                dfs(neigh,newNode,vis);
            }else{
                copy.neighbors.add(vis[neigh.val]);
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Node copy = new Node(node.val);
        Node vis[] = new Node[101];
        dfs(node,copy,vis);
        return copy;
    }
}