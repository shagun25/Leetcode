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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode fakeNode = new ListNode(-1);
       fakeNode.next=head;
       ListNode prev = fakeNode;
       ListNode curr = fakeNode.next;
        int i=1;
       while(i<left){
           prev=curr;
           curr=curr.next;
           i++;
       }
        ListNode node = prev;
        while(i<=right){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            i++;
        }
        node.next.next=curr;
        node.next=prev;
        return fakeNode.next;
    }
    
}