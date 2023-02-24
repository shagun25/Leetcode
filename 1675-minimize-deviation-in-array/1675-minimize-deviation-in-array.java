class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            if(num%2==1) num*=2;
            min=Math.min(min,num);
            pq.add(num);
        }
        int diff = Integer.MAX_VALUE;
        while(pq.peek()%2==0){
            int max=pq.poll();
            diff=Math.min(diff,max-min);
            min=Math.min(max/2,min);
            pq.add(max/2);
        }
        return Math.min(diff,pq.peek()-min);
    }
    
}