class Solution {
    boolean valid(int nums[],int maxValue){
       long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>(long)maxValue*(i+1)){
                return false;
            }
        }
        return true;
    }
    public int minimizeArrayValue(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num :nums){
            max=Math.max(num,max);
        }
        int l=0,r=max,ans=0;
        while(l<=r){
            int m = l+(r-l)/2;
            if(valid(nums,m)){
                ans=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
}