/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode node,int level){
        this.node = node;
        this.level = level;
    }
}
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root==null) {
            if(depth==1) return new TreeNode(val);
            else return null;
        }if(depth==1) {
            TreeNode node=new TreeNode(val);
            node.left=root;
            return node;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,1));
        
        boolean flag=false;
        while(!queue.isEmpty()){
            int sz = queue.size();
            for(int i=0;i<sz;i++){
                Pair rm = queue.poll();
                TreeNode lft = rm.node.left;
                TreeNode rght = rm.node.right;
                if(rm.level==depth-1) {
                    rm.node.left =  new TreeNode(val); rm.node.left.left=lft;
                    rm.node.right =  new TreeNode(val); rm.node.right.right=rght;
                    flag=true;
                }else{
                    if(rm.node.left!=null) queue.add(new Pair(rm.node.left,rm.level+1));
                if(rm.node.right!=null) queue.add(new Pair(rm.node.right,rm.level+1));
                }
                
            }
           if(flag) return root;
        }
        return root;
    }
}