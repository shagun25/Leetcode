class Solution {
    public int maxProfit(int[] prices) {
        //Bidirectional DP
        int n = prices.length;
        int left[] = new int[n];
        int min = prices[0];
        left[0]=0;
        for(int i=1;i<n;i++){
            min = Math.min(min,prices[i]);
            left[i]=Math.max(left[i-1],prices[i]-min);
        }
        int right[] = new int[n];
        int max = prices[n-1];
        right[n-1]=0;
        for(int i=n-2;i>=0;i--){
            max = Math.max(max,prices[i]);
            right[i]=Math.max(right[i+1],max-prices[i]);
        }
        int profit=0;
        for(int i=0;i<n;i++){
            profit=Math.max(profit,left[i]+right[i]);
        }
        return profit;
    }
}