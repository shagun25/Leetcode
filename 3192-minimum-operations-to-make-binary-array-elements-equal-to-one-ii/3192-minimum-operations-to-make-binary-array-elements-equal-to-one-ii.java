class Solution {
    public int minOperations(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==1 && nums[i-1]==0){
                count+=2;
            }
        }
        if(nums[nums.length-1]==0) count++;
        return count;
    }
}

