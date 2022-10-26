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
    public List<Integer> postorderTraversal(TreeNode root) {
    //morris
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            res.add(curr.val);
            if (curr.right == null) {
                curr = curr.left; 
            } else { 
                pre = curr.right;
                while (pre.left != null) { 
                    pre = pre.left;
                }
                pre.left = curr.left; 
                TreeNode temp = curr;
                curr = curr.right; 
                temp.right = null;
            }
        }
        Collections.reverse(res);
        return res;
    }
}