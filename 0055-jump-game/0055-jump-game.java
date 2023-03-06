class Solution {
    public boolean canJump(int[] nums) {
        //Valley peak approach
        int maxReachable=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(maxReachable<i) return false;
            maxReachable=Math.max(maxReachable,i+nums[i]);
        }
        return true;
    }
}