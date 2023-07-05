class Solution {
    public int longestSubarray(int[] nums) {
        int zeroCount=0,start=0,longest=0;
        for(int i=0;i<nums.length;i++){
            zeroCount+=(nums[i]==0)?1:0;
            while(zeroCount>1){
                zeroCount-=(nums[start]==0)?1:0;
                start++;
            }
            longest = Math.max(longest,i-start);
        }
        return longest;
    }
}