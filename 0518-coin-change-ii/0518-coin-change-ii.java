class Solution {
    public int numberOfWays(int i, int amount, int[] coins, int dp[][]) {
        if (amount == 0) {
            return 1;
        }
        if (i == coins.length) {
            return 0;
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        if (coins[i] > amount) {
            return dp[i][amount]=numberOfWays(i + 1, amount, coins, dp);
        }

        return dp[i][amount]=numberOfWays(i, amount - coins[i], coins, dp) + numberOfWays(i + 1, amount, coins, dp);
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int d[]: dp) Arrays.fill(d,-1);
        return numberOfWays(0, amount, coins, dp);
    }
}