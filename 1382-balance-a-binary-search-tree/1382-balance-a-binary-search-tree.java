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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        sortedArray(root, arr);
        return sortedToBST(arr, 0, arr.size()-1);
    }
    public void sortedArray(TreeNode root, ArrayList<Integer> arr){
        if(root==null) return;
        sortedArray(root.left, arr);
        arr.add(root.val);
        sortedArray(root.right, arr);
    }
    public TreeNode sortedToBST(ArrayList<Integer> arr, int s, int e){
        if(s>e) return null;
        int m = s + (e-s)/2;
        TreeNode left = sortedToBST(arr, s, m-1);
        TreeNode right = sortedToBST(arr, m+1, e);
        return new TreeNode(arr.get(m), left, right);
    }
}