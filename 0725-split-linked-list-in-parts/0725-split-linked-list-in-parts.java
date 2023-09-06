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
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int n = 0;
        ListNode curr = head;
        while(curr!=null){
            n++;
            curr = curr.next;
        }
        curr = head;
        int size = n/k, extra = n%k;
        for(int i=0;i<n && curr!=null;i++){
            res[i] = curr;
            for(int j=0;j<size+(extra>0?1:0)-1;j++) curr = curr.next;
            ListNode temp = curr.next;
            curr.next = null;
            curr = temp;
            extra--;
        }
        return res;
    }
}