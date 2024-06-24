class Solution {
    public int minOperations(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count++;
                if(i+3>nums.length) return -1;
                for(int k=i;k<i+3;k++){
                    nums[k]=(nums[k]==0)?1:0;
                }
            }
        }
        return count;
    }
}