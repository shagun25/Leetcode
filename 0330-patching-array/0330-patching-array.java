class Solution {
    public int minPatches(int[] nums, int n) {
        int s=0,count=0;
        long sum=0;
        for(int i=1;i<=n && s<nums.length;i++){
            if(sum>=i) continue;
            else if(nums[s]>i){
                count++;
                sum+=i;
            }else{
                sum+=nums[s];
                s++;
            }
        }
        while(sum<n){
            sum+=sum+1;
            count++;
        }
       return count;
    }
}