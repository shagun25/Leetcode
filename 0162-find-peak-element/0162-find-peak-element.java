class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int l=0,h=nums.length-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(m>0 && m<nums.length-1){
                if(nums[m-1]<nums[m] && nums[m]>nums[m+1]) return m;
                else if(nums[m-1]>nums[m]) h=m-1;
                else l=m+1;
            }
            else if(m==0){
                if(nums[0]>nums[1]) return 0;
                else return 1;
            }else{
                if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
                else return nums.length-2;
            }
        }
        return -1;
    }
}