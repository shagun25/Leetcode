class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0,h=nums.length-1,left=-1,right=-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(nums[m]==target){
                    int i=m;
                    while(i>0 && nums[i]==nums[i-1]) i--;
                    left=i;
                    i=m;
                    while(i<nums.length-1 && nums[i]==nums[i+1]) i++;
                    right=i;
                    return new int[]{left,right};
                
            }else if(nums[m]<target){
                l=m+1;
            }else{
                h=m-1;
            }
        }
        return new int[]{left,right};
    }
}