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
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        
        if(root==null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        boolean even=true;
        while(!queue.isEmpty()){
            int sz = queue.size();
            int preVal = even?Integer.MIN_VALUE:Integer.MAX_VALUE;
            for(int i=0;i<sz;i++){
                TreeNode node = queue.poll();
                if(even){
                    if(node.val%2==0 || preVal>=node.val) return false;
                }else{
                    if(node.val%2==1 || preVal<=node.val) return false;
                }
                preVal=node.val;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            even=!even;
           
        }
        return true;
    }
}