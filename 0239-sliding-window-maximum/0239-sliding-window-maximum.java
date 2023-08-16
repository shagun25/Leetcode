class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] resultList = new int[nums.length - k + 1];        
        int winStart = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((eP1, eP2)-> nums[eP2] - nums[eP1]);
        
        for(int i=0; i < k ; i++)
            maxHeap.offer(i); 
        
        resultList[winStart++] = nums[maxHeap.peek()];
        
        for(int winEnd = k ; winEnd < nums.length; winEnd++){
            while(!maxHeap.isEmpty() && maxHeap.peek() < winStart)
                maxHeap.poll();
            
            maxHeap.offer(winEnd);
            resultList[winStart++] = nums[maxHeap.peek()];
        }
        return resultList;
    }
}