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
    boolean res = false;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        helper(root,x,n);
        return res;
    }
    int helper(TreeNode root, int x, int n){
        if(root==null) return 0;
        int left = helper(root.left,x,n);
        int right = helper(root.right,x,n);
        if(root.val==x){
            int parent = n-(left+right+1);
            if((parent>left+right) || (left>parent+right) || (right>parent+left)) res=true;
        }
        return left+right+1;
    }
}