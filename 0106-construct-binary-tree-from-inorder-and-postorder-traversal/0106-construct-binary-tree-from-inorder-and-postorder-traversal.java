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
    int postIndex=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex=postorder.length-1;
        return solve(postorder,inorder,0,inorder.length-1,inorder.length);
    }
    int findPos(int[] inorder,int x){
        for(int i=0;i<inorder.length;i++) if(inorder[i]==x) return i;
        return -1;
    }
    TreeNode solve(int[] postorder, int[] inorder,int instr,int inend,int n){
        if(postIndex<0|| instr>inend) return null;
        TreeNode root = new TreeNode(postorder[postIndex]);
        int pos = findPos(inorder,postorder[postIndex]);
        postIndex--;
        root.right=solve(postorder,inorder,pos+1,inend,n);
        root.left=solve(postorder,inorder,instr,pos-1,n);
        return root;
    }
}