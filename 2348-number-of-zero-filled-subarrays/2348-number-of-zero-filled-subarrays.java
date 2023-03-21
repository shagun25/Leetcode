class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        long num_subArray=0;
        for(int num : nums){
            if(num==0){
                num_subArray++;
            }else{
                num_subArray=0;
            }
            ans+=num_subArray;
        }
        return ans;
    }
}