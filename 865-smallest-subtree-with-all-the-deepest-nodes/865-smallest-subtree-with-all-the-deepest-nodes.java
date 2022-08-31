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
    int maxDepth=-1;
    TreeNode res=null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
       helper(root,0);
        return res;
    }
    int helper(TreeNode root,int height){
        if(root==null) return height;
        int left = helper(root.left,height+1);
        int right = helper(root.right,height+1);
        if(left==right){
            if(maxDepth<=left){
                maxDepth=left;
                res=root;
            }
        }
        return Math.max(left,right);
    }
}