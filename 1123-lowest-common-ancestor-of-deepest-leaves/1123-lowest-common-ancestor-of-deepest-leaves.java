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
    int depth;
    Pair(TreeNode node,int depth){
        this.node = node;
        this.depth = depth;
    }
}
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair pair = helper(root,0);
        return pair.node;
    }
    Pair helper(TreeNode root,int d){
        if(root==null) return new Pair(null,d);
        Pair left = helper(root.left,d+1);
        Pair right = helper(root.right,d+1);
        if(left.depth == right.depth) return new Pair(root,left.depth);
        if(left.depth>right.depth) return left;
        return right;
    }
}