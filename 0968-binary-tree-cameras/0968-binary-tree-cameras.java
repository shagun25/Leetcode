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
    // 0 -> cover me 
    // 1 -> I am covered, you see yourself
    // -1 -> Installing camera, you are also covered.
    int cameras=0;
    public int minCameraCover(TreeNode root) {
        int temp = helper(root);
        return temp==0?cameras+1:cameras;
    }
    int helper(TreeNode root){
        if(root==null) return 1;
        int left = helper(root.left);
        int right = helper(root.right);
        if(left==0 || right==0){
            cameras++;
            return -1;
        }
        if(left==-1 || right==-1){
            return 1;
        }
        return 0;
    }
}