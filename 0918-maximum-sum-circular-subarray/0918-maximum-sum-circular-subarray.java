class Solution {
    int maxSubarraySumKadane(int[] nums){
         int N = nums.length;
        int sum=0,max=Integer.MIN_VALUE;
         for(int i=0;i<N;i++){
             sum=Math.max(sum+nums[i],nums[i]);
             max=Math.max(sum,max);
         }
        return max;
    }
     int minSubarraySumKadane(int[] nums){
         int N = nums.length;
        int sum=0,min=Integer.MAX_VALUE;
         for(int i=0;i<N;i++){
             sum=Math.min(sum+nums[i],nums[i]);
             min=Math.min(sum,min);
         }
        return min;
    }
    public int maxSubarraySumCircular(int[] nums) {
        // Case 1: All are negative 
        //     ans will be one max of al negative -> return normal maxKadane
        // Case 2: mix positive-negative
        //     case 2.1: max Subbarray can be one side -> return normal maxKadane
        //     case 2.2: max Subbarray both the edge sides -> return (totalSum-minKadane)
        int totalSum=0;
        for(int x:nums) totalSum+=x;
        int minKadane = minSubarraySumKadane(nums);
        int maxKadane = maxSubarraySumKadane(nums);
        if(totalSum==minKadane) return maxKadane;
        return Math.max(totalSum-minKadane,maxKadane);
    }
}