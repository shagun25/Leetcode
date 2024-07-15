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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int description[]: descriptions){
            int p = description[0];
            int c = description[1];
            int l = description[2];
            if(!map.containsKey(p)){
                TreeNode node = new TreeNode(p);
                map.put(p,node);
            }
            if(!map.containsKey(c)){
                TreeNode node = new TreeNode(c);
                map.put(c,node);
            }
            if(l==1) map.get(p).left = map.get(c);
            else map.get(p).right = map.get(c);
            set.add(c); 
        }
        for(Map.Entry<Integer,TreeNode> entry: map.entrySet()){
            if(!set.contains(entry.getKey())) return map.get(entry.getKey());
        }
        return null;
    }
}