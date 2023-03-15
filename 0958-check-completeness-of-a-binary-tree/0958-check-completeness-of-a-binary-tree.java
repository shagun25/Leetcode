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
    int countNodes(TreeNode root){
        if(root==null) return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    public boolean isCompleteTree(TreeNode root) {
        return dfs(root,0,countNodes(root));
    }
    boolean dfs(TreeNode root,int index,int n){
        if (root == null) {
            return true;
        }
        // If index assigned to current node is greater or equal to the number of nodes
        // in tree, then the given tree is not a complete binary tree.
        if(index>=n) return false;
        return dfs(root.left,2*index+1,n) && dfs(root.right,2*index+2,n);
    }
}