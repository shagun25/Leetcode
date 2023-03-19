class Solution {
    
    public int maxProfit(int k, int[] prices) {
        //Dp
        int n = prices.length;
        if(n<2) return 0;//only one stock, buy sell on same day=0.
        int dp[][] = new int[k+1][n]; // space: O(k*n)
        
        //TC: O(k*n*n)
        for(int i=1;i<=k;i++){
            int effectiveBuyPrice=prices[0];
            for(int j=1;j<n;j++){
                dp[i][j] = Math.max(dp[i][j-1],prices[j]-effectiveBuyPrice);
                effectiveBuyPrice=Math.min(effectiveBuyPrice,prices[j]-dp[i-1][j]);
            }
        }
        return dp[k][n-1];
    }
}