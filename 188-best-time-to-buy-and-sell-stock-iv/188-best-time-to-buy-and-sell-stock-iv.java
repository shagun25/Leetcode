class Solution {
    public int maxProfit(int K,int[] prices) {
        int dp[][] = new int[K+1][prices.length];
         if(prices.length==0) return 0;
        for(int i=1;i<=K;i++){
            for(int j=1;j<prices.length;j++){
                dp[i][j]=dp[i][j-1];
                for(int k=0;k<j;k++){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][k]+prices[j]-prices[k]);
                }   
            }
        }
        return dp[K][prices.length-1];
    }
}