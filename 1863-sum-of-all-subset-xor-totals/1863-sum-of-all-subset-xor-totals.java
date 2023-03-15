class Solution {
    int solve(int[] nums,int index,int xor){
        if(index>=nums.length) return xor;
        return solve(nums,index+1,xor)+solve(nums,index+1,nums[index]^xor);
    }
    public int subsetXORSum(int[] nums) {
        return solve(nums,0,0);
    }
}