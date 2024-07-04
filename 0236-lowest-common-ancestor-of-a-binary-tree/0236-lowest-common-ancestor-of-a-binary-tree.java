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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<Integer> pPath = new ArrayList<>();
        dfsTraversal(root, p, pPath);
         Collections.reverse(pPath);
        System.out.print("pPath: "+ pPath);
        
         List<Integer> qPath = new ArrayList<>();
        dfsTraversal(root, q, qPath);
         Collections.reverse(qPath);
        System.out.print("qPath: "+ qPath);
        
        
        int i=0,j=0;
        while(i<pPath.size() && j<qPath.size()){
            if(pPath.get(i).equals(qPath.get(i))) {
              i++;j++;
            }else break;
        }
        //  int i = 0;
        // while (i < pPath.size() && i < qPath.size() && pPath.get(i).equals(qPath.get(i))) {
        //     i++;
        // }
        return new TreeNode(pPath.get(i-1));
    }
    boolean dfsTraversal(TreeNode root, TreeNode x,  List<Integer> path){
        if(root==null) return false;
        if(root.val==x.val) {
            path.add(root.val);
            return true;
        }
        if(dfsTraversal(root.left, x, path)) {
            path.add(root.val);
            return true;
        }
        if(dfsTraversal(root.right, x, path)) {
            path.add(root.val);
            return true;
        }
        return false;
    }
}