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
    StringBuilder pathToStart;
    StringBuilder pathToDest;
    public String getDirections(TreeNode root, int startValue, int destValue) {
         TreeNode ans = lca(root, startValue, destValue);

         pathToStart = new StringBuilder();
         pathToDest = new StringBuilder();
         findPath(ans, startValue, pathToStart);
         findPath(ans, destValue, pathToDest);

         StringBuilder directions = new StringBuilder();
         directions.append("U".repeat(pathToStart.length()));
         directions.append(pathToDest);

        return directions.toString();

    }
    public boolean findPath(TreeNode node, int x, StringBuilder path) {
        if (node == null) return false;

        if (node.val == x) return true;

        path.append("L");
        if (findPath(node.left, x, path)) {
            return true;
        }
        path.setLength(path.length() - 1); 

        path.append("R");
        if (findPath(node.right, x, path)) {
            return true;
        }
        path.setLength(path.length() - 1); 

        return false;
    }
    public TreeNode lca(TreeNode root, int p, int q) {
        if(root==null) return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if(root.val==p || root.val==q) {
            return root;
        }
        if(left!=null && right!=null) return root; 
        if(left!=null) return left; 
        return right;  
    }
}