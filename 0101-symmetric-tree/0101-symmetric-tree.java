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
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode leftNode = q.poll();
            TreeNode rightNode = q.poll();

            if(leftNode==null && rightNode==null) continue;
            if(leftNode==null || rightNode==null || leftNode.val != rightNode.val) return false;
            q.add(leftNode.left);
            q.add(rightNode.right);
            q.add(leftNode.right);
            q.add(rightNode.left);
        }
        return true;
    }
}