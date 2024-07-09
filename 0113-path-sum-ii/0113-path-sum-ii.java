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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, 0, new ArrayList<Integer>(), targetSum);
        return res;
    }
    void helper(TreeNode root, int sum, List<Integer> sumPath, int targetSum){
        if(root==null) return;
        if(root.left==null && root.right==null){
            if(root.val+sum==targetSum) {
                sumPath.add(root.val);
                res.add(sumPath);
            }
            return;
        }
        sumPath.add(root.val);
        helper(root.left, sum+root.val, new ArrayList<>(sumPath), targetSum);
        helper(root.right, sum+root.val, new ArrayList<>(sumPath), targetSum);
    }
}