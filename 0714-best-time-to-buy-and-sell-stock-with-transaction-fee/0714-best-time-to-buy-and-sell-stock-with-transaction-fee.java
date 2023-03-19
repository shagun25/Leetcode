class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit=0;
        int effectiveBuyPrice=prices[0];
        for(int i=1;i<prices.length;i++){
            int curr_profit = prices[i]-effectiveBuyPrice-fee;
            profit = Math.max(profit,curr_profit);
            effectiveBuyPrice=Math.min(effectiveBuyPrice,prices[i]-profit);
        }
        return profit;
    }
}