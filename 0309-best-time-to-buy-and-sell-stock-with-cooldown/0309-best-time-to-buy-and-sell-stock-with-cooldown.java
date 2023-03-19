class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sold=Integer.MIN_VALUE;
        int held=Integer.MIN_VALUE;
        int reset=0;
        for(int i=0;i<n;i++){
            int prev_sold = sold;
            sold = held+prices[i];
            held = Math.max(held,reset-prices[i]);
            reset = Math.max(reset,prev_sold);
        }
        return Math.max(sold,reset);
    }
}