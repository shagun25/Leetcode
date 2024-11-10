class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length, max=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int xor=0;
            for(int j=i;j<n;j++){
                xor=xor | nums[j];
                if(xor>=k) {
                    int length = j-i+1;
                    if(length<max) max=length;
                    break;
                }
            }
        }
        return max==Integer.MAX_VALUE?-1:max;
    }
}