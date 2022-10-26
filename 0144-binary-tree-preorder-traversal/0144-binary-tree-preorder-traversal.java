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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            res.add(curr.val);
            if (curr.left == null) {
                curr = curr.right; 
            } else { 
                pre = curr.left;
                while (pre.right != null) { 
                    pre = pre.right;
                }
                pre.right = curr.right; 
                TreeNode temp = curr;
                curr = curr.left; 
                temp.left = null;
            }
        }
        return res;
    }
}