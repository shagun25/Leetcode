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
    public int maxLevelSum(TreeNode root) {
       
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max=Integer.MIN_VALUE,lev=1,level=1;
        while(!queue.isEmpty()){
            int sz = queue.size();
            int res=0;
            for(int i=0;i<sz;i++){
                TreeNode node = queue.poll();
                res+=node.val;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            if(res>max) {max=Math.max(max,res);level=lev;}
            lev++;
           
        }
        return level;
    }
}