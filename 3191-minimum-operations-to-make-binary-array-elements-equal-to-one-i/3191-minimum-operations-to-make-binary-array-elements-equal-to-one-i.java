class Solution {
    public int minOperations(int[] nums) {
        int count=0,i=0;
        for(int j=2;j<nums.length;j++){
            if(nums[i]==0){
                count++;
                for(int k=i;k<i+3;k++){
                    nums[k]=(nums[k]==0)?1:0;
                }
            }
            i++;
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]==0){
                return -1;
            }
        }
        return count;
    }
}