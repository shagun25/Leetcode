class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<Integer>();
        Deque<Integer> minDeque = new LinkedList<Integer>();
        int start = 0;
        int res = 0;
        for(int end=0;end<nums.length;end++){
            while(!maxDeque.isEmpty() && maxDeque.peekLast()<nums[end]){
                maxDeque.pollLast();
            }
             maxDeque.offerLast(nums[end]);
            while(!minDeque.isEmpty() && minDeque.peekLast()>nums[end]){
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[end]);
            while(!maxDeque.isEmpty() && !minDeque.isEmpty() && Math.abs(maxDeque.peekFirst()-minDeque.peekFirst())>limit){
                if(maxDeque.peekFirst()==nums[start]){
                    maxDeque.pollFirst();
                }
                if(minDeque.peekFirst()==nums[start]){
                    minDeque.pollFirst();
                }
                start++;
            }
            res=Math.max(res,end-start+1);
        }
        return res;
    }
}