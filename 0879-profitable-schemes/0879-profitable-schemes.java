class Solution {
    int mod = 1000000007;
    int dp[][][];
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp = new int[n + 1][group.length + 1][minProfit + 1];
        for (int[][] d : dp) {
            for (int[] e: d) {
                Arrays.fill(e, -1);
            }
        }
        return helper(group, profit, minProfit, n, 0);
    }

    private int helper(int[] group, int[] profit, int minProfit, int maxPeople, int idx) {
        if (maxPeople < 0) {
            return 0;
        }
        if (idx == group.length) {
            return minProfit <= 0 ? 1 : 0;
        }
        if (minProfit < 0) {
            minProfit = 0;
        }
        if (dp[maxPeople][idx][minProfit] != -1) {
            return dp[maxPeople][idx][minProfit];
        }
        int pick = helper(group, profit, minProfit - profit[idx], maxPeople - group[idx], idx + 1);
        int notPick = helper(group, profit, minProfit, maxPeople, idx + 1);

        return dp[maxPeople][idx][minProfit] = (int) (pick + notPick) % mod;
    }
}