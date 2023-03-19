class Solution {
    
    public int maxProfit(int k, int[] prices) {
        //Dp
        int n = prices.length;
        if(n<2) return 0;//only one stock, buy sell on same day=0.
        int dp[][] = new int[k+1][n]; // space: O(k*n)
        
        //TC: O(k*n*n)
        for(int i=1;i<=k;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = Math.max(dp[i][j-1],helper(dp,prices,i,j));
            }
        }
        return dp[k][n-1];
    }
    int helper(int dp[][], int[] prices, int k, int day_x){
        int max=0;
        for(int x=0;x<day_x;x++){
            //sell on day_x, buy on day x, and add profit from i-1 transactions i.e dp[k-1][x]
            max=Math.max(max,dp[k-1][x]+prices[day_x]-prices[x]);
        }
        return max;
    }
}