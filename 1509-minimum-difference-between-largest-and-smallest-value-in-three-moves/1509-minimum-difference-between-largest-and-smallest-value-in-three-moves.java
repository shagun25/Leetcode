public class Solution {

    public int minDifference(int[] nums) {
        int numsSize = nums.length;
        if (numsSize <= 4) {
            return 0;
        }

        List<Integer> smallestFour = heapify(new PriorityQueue<>(
            Collections.reverseOrder()
        ), nums);

        List<Integer> largestFour = heapify(new PriorityQueue<>(), nums);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            minDiff = Math.min(
                minDiff,
                largestFour.get(i) - smallestFour.get(i)
            );
        }

        return minDiff;
    }
    List<Integer> heapify(PriorityQueue<Integer> heap, int[] nums){
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > 4) {
                heap.poll();
            }
        }
        List<Integer> list = new ArrayList<>(heap);
        Collections.sort(list);
        return list;
    }
}