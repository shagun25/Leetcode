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
    
//     Approach & Complete Inutuition
// Method 1: Brute Force
// Method 2: Compare K elements One By One
// Method 3: Compare K elements by Priority Queue
// Method 4: Merge 2 Lists at a time
// Method 5: Merge K lists by Divide & Conquer (Most Optimal)
    
    public ListNode mergeKLists(ListNode[] lists) {
        //Method1
        ArrayList<Integer> arr = new ArrayList<>();
        for(ListNode list : lists){
            while(list!=null){
                arr.add(list.val);
                list=list.next;
            }
        }
        Collections.sort(arr);
        ListNode res = new ListNode(-1);
        ListNode head = res;
        for(int a : arr){
            ListNode curr = new ListNode(a);
            res.next=curr;
            res=curr;
        }
        return head.next;
    }
}