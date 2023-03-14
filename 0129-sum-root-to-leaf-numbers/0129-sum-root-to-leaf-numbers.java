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
    int Sum=0;
    public int sumNumbers(TreeNode root) {
       binaryTreePaths(root,"");
        return Sum;
    }
    public void binaryTreePaths(TreeNode root,String sum) {
        if(root==null) return;
         if(root.left==null && root.right==null){
            sum+=root.val;
             Sum+=Integer.parseInt(sum);
            return;
        }
       binaryTreePaths(root.left,sum+root.val);
       binaryTreePaths(root.right,sum+root.val);
    }
}