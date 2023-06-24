class Solution {
    public int longestArithSeqLength(int[] nums) {
    int n = nums.length;
    int[][] dp = new int[n][n];
    int maxLen = 2;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            dp[i][j] = 2;
            int diff = nums[j] - nums[i];
            for (int k = i - 1; k >= 0; k--) {
                if (nums[i] - nums[k] == diff) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                    break;
                }
            }
            maxLen = Math.max(maxLen, dp[i][j]);
        }
    }
    return maxLen; 
    }
}