class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());
        for(int x:nums){
            pq.add(x);
        }
        long score=0;
        for(int i=0;i<k;i++){
            int x=pq.poll();
            score+=x;
            int y=(int)Math.ceil((double)x/3);
            pq.add(y);
        }
        return score;
    }
}