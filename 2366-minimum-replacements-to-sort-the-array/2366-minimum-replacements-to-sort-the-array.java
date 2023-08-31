class Solution {
    public long minimumReplacement(int[] nums) {
        long res = 0;
        int n = nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=nums[i+1]) continue;
            long numElem = (long)(nums[i]+nums[i+1]-1)/(long)(nums[i+1]);
            res+=numElem-1;
            nums[i]=nums[i]/(int)numElem;
            //System.out.println(nums[i]);
        }
       return res; 
    }
}