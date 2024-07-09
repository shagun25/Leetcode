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
      int res=0;
     public int pathSum(TreeNode root, int targetSum) {
          if(root==null) return 0;
         helper(root,0,targetSum);
         pathSum(root.left,targetSum);
         pathSum(root.right,targetSum);
         return res;
    }
    public void helper(TreeNode root,long sum, int targetSum) {
        if(root==null) return;
            sum+=root.val;
             if(sum==targetSum) {
                res++;
             }
        
       helper(root.left,sum,targetSum);
       helper(root.right,sum,targetSum); 
    }
}