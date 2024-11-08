class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xorall=0;
        for(int num: nums){
            xorall^=num;
        }
        int max = (int)Math.pow(2,maximumBit)-1;
        int ans[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=xorall^max;
            xorall=xorall^nums[nums.length-1-i];
        }
        return ans;
    }
}