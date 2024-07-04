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
    boolean nodeToRootPath(TreeNode root,TreeNode x,ArrayList<TreeNode> arr){
       if(root==null) return false;
        if(root.val==x.val) {
           arr.add(root);
           return true;
       }
        if(nodeToRootPath(root.left,x,arr)) {
            arr.add(root);
            return true;
        }
        if(nodeToRootPath(root.right,x,arr)) {
            arr.add(root);
            return true;
        }
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> arr1 = new ArrayList<TreeNode>(); 
        nodeToRootPath(root,p,arr1);
        ArrayList<TreeNode> arr2 = new ArrayList<TreeNode>();
        nodeToRootPath(root,q,arr2);
        int n = (arr1.size()>arr2.size())?arr2.size():arr1.size();
        int i=0,j=0;
        for(i=arr1.size()-1, j=arr2.size()-1;i>=0 && j>=0;i-- ,j--){
            if(arr1.get(i)!=arr2.get(j)) break;
        }
        return arr1.get(i+1);
    }
}