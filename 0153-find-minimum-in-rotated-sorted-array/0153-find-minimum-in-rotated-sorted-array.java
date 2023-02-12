class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(nums[0]<nums[n-1]) return nums[0];
        int l=0,h=n-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(nums[m]>nums[m+1]) return nums[m+1];
            else if(nums[m-1]>nums[m]) return nums[m];
            else if(nums[l]<=nums[m]) l=m+1;
            else h=m-1;
        }
        return -1;
    }
}