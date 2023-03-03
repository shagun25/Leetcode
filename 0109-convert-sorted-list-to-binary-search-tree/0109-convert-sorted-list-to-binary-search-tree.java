/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> li = new ArrayList<>();
        while(head != null)
        {
            li.add(head.val);
            head = head.next;
        }
       return CreateBST(li,0,li.size()-1);
    }
    TreeNode CreateBST(List<Integer> list,int l,int r){
        if(l>r) return null;
        int m = (l+r)/2;
        TreeNode root = new TreeNode(list.get(m));
        root.left = CreateBST(list,l,m-1);
        root.right = CreateBST(list,m+1,r);
        return root;
    }
}