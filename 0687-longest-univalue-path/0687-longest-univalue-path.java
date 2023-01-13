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
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans=0;
        dfs(root);
        return ans;
    }
    int dfs(TreeNode root){
        if(root==null) return 0;
        int left =  dfs(root.left);
        int right =  dfs(root.right);
        int dfsLeft=0,dfsRight=0;
        if(root.left!=null && root.left.val==root.val) dfsLeft+=left+1;
        if(root.right!=null && root.right.val==root.val) dfsRight+=right+1;
        ans = Math.max(ans,dfsLeft+dfsRight);
        return Math.max(dfsLeft,dfsRight);
    }
}