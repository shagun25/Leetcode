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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode curr = head.next;
        ListNode prev = head;
        int i=0;
        while(curr!=null && curr.next!=null){
            if((prev.val<curr.val && curr.val>curr.next.val) || (prev.val>curr.val && curr.val<curr.next.val)) res.add(i);
            prev=curr;
            curr = curr.next;
            i++;
        }
        System.out.print("res: "+res);
        int n = res.size();
        if(n<=1) return new int[]{-1,-1};
       int max = res.get(n-1)-res.get(0);
        int min = Integer.MAX_VALUE;
        for(int j=1;j<n;j++){
            min=Math.min(min,res.get(j)-res.get(j-1));
        }
        return new int[]{min,max};
    }
}