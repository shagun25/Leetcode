class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // Case 1: All are negative 
        //     ans will be one max of al negative -> return normal maxKadane
        // Case 2: mix positive-negative
        //     case 2.1: max Subbarray can be one side -> return normal maxKadane
        //     case 2.2: max Subbarray both the edge sides -> return (totalSum-minKadane)
        int totalSum=0;
        int N = nums.length;
        int sumMin=0,max=Integer.MIN_VALUE;
        int sumMax=0,min=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
             sumMin=Math.max(sumMin+nums[i],nums[i]);
             max=Math.max(sumMin,max);
             sumMax=Math.min(sumMax+nums[i],nums[i]);
             min=Math.min(sumMax,min);
             totalSum+=nums[i];
        }
        return (totalSum==min)?max:Math.max(totalSum-min,max);
    }
}