class Solution {
    public int maxProfit(int[] prices) {
        int profit=0,b=0,s=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>=prices[i-1]) s++;
            else {
                profit+=prices[s]-prices[b];
                s=b=i;
            }
        }
        profit+=prices[s]-prices[b];
        return profit;
    }
}