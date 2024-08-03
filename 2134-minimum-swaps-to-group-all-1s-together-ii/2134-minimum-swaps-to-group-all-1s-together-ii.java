class Solution {
    public int minSwaps(int[] nums) {
        // int l=0,r=nums.length-1;
        // while(l<=r){
        //     if(nums[l]==1) l++;
        //     if(nums[r]==1) r--;
        //     else if(nums[l]==0 || nums[r]==0) break;
        // }
        // boolean flag=false;
        // for(int i=l;i<=r;i++){
        //     //System.out.println("l: "+ l+" r: "+ r);
        //     if(nums[i]==1) flag=true;
        // }
        // if(!flag) return 0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) count++;
        }
        int maxCount=0;
        for(int i=0;i<count;i++){
            if(nums[i]==1) maxCount++;
        }
        int kcount=maxCount;
        for(int i=0;i<nums.length;i++){
            if(nums[(i+count)%nums.length]==1) kcount++;
            if(nums[i]==1) kcount--;
            maxCount=Math.max(maxCount,kcount);
        }
        return count-maxCount;
    }
}