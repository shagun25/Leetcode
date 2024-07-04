/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        if(p.val<root.val && q.val<root.val) return lowestCommonAncestor(root.left, p, q);// Case3: p and q both lies on right side, whichever you find first will be the ans.
        else if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right, p, q);// Case2: p and q both lies on left side, whichever you find first will be the ans.
        else return root;  // Case1: p and q lies in left and right or vice versa.
    }
}
