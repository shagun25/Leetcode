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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode hl = less;
        ListNode greater = new ListNode(0);
        ListNode hg = greater;
        while(head!=null){
            if(head.val<x) {
                less.next = new ListNode(head.val);
                less = less.next;
            }
            else {
                greater.next = new ListNode(head.val);
                greater = greater.next;
            }
            head = head.next;
        }
        less.next = hg.next;
        return hl.next;
    }
}