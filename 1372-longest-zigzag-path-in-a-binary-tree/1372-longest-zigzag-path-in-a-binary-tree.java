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
    int pathLength=0;
    void dfs(TreeNode root, boolean goLeft, int steps){
        if(root==null) return;
        pathLength = Math.max(pathLength, steps);
        if(goLeft){
            dfs(root.left,false,steps+1);
            dfs(root.right,true,1);
        }else{
            dfs(root.left,false,1);
            dfs(root.right,true,steps+1);
        }
    }
    public int longestZigZag(TreeNode root) {
        dfs(root,true,0);
        dfs(root,false,0);
        return pathLength;
    }
}