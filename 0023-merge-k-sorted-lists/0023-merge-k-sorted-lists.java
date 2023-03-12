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


//     Approach & Complete Inutuition
// Method 1: Brute Force      [tc: O(NlogN), sc:O(N) ]
// Method 2: Compare K elements One By One    [tc: O(Nk), sc:O(N) ]
// Method 3: Compare K elements by Priority Queue    [tc: O(Nk), sc:O(N+k) ]
// Method 4: Merge 2 Lists at a time   [tc: O(kN), sc:O(1) ]
// Method 5: Merge K lists by Divide & Conquer (Most Optimal)  [tc: O(klogk + NlogK) => O(NlogK), sc:O(logK) ]
class Solution {
    
    //Method1 Brute Force
    // public ListNode mergeKLists(ListNode[] lists) {
    //     ArrayList<Integer> arr = new ArrayList<>();
    //     for(ListNode list : lists){
    //         while(list!=null){
    //             arr.add(list.val);
    //             list=list.next;
    //         }
    //     }
    //     Collections.sort(arr);
    //     ListNode res = new ListNode(-1);
    //     ListNode head = res;
    //     for(int a : arr){
    //         ListNode curr = new ListNode(a);
    //         res.next=curr;
    //         res=curr;
    //     }
    //     return head.next;
    // }
    
    //Method3 Compare K elements by Priority Queue
//     public ListNode mergeKLists(ListNode[] lists) {
//         int n = lists.length;
//         if (lists == null || n == 0) return null;
        
//         // Ensure our pq takes in ListNodes and compares their values.
//         PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);
        
//         // Add the head of all non-null lists to the pq to begin.
//         for (ListNode list: lists)
//             if (list != null) pq.add(list);
        
//         // Dummy node pointer to help add to our output list.
//         ListNode ptr = new ListNode(-1);
//         ListNode head = ptr;
        
//         // 1) Get the smallest node from the PriorityQueue.
//         // 2) Add it to our output list.
//         // 3) Add the next node of the current list to the pq if it's not null
//         // 4) Repeat
//         while (!pq.isEmpty()) {
//             ListNode curr = pq.poll();
//             ptr.next = new ListNode(curr.val);
//             ptr = ptr.next;
//             if (curr.next != null) pq.add(curr.next);
//         }
        
//         return head.next;    
//     }
    
    // Method 5: Merge K lists by Divide & Conquer (Most Optimal)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        return helper(lists, 0, lists.length-1);
    }

    public ListNode helper(ListNode[] lists, int left, int right){
        if(left == right) return lists[left];

        int mid = left + (right-left)/2;
        ListNode first = helper(lists, left, mid);
        ListNode second = helper(lists, mid+1, right);
        return merge(first, second);
    }

    public ListNode merge(ListNode list1, ListNode list2){
        ListNode temp = new ListNode(0);
        ListNode p = temp;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            }else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if(list1!=null){
            p.next = list1;
        }
        if(list2!=null){
            p.next = list2;
        }
        return temp.next;
    }
}