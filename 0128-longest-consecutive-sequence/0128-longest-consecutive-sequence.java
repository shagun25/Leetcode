class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        Arrays.sort(nums);
        int n = nums.length;
        int currentStreak=1;
        int maxStreak=1;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]) continue;
            else if(nums[i]==nums[i-1]+1) {
                currentStreak+=1;
                maxStreak=Math.max(maxStreak,currentStreak);
            }
            else {
                currentStreak=1;
            }
        }
        return maxStreak;
    }
}