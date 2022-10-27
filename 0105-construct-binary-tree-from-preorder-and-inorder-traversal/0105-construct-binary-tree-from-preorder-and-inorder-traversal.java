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
    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder,inorder,0,inorder.length-1,inorder.length);
    }
    int findPos(int[] inorder,int x){
        for(int i=0;i<inorder.length;i++) if(inorder[i]==x) return i;
        return -1;
    }
    TreeNode solve(int[] preorder, int[] inorder,int instr,int inend,int n){
        if(preIndex>=n || instr>inend) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        int pos = findPos(inorder,preorder[preIndex]);
        preIndex++;
        root.left=solve(preorder,inorder,instr,pos-1,n);
        root.right=solve(preorder,inorder,pos+1,inend,n);
        return root;
    }
}