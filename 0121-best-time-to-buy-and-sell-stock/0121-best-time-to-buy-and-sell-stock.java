class Solution {
    public int maxProfit(int[] prices) {
        int lsf=Integer.MAX_VALUE;
        int profit=0;
        for(int price : prices){
            lsf=Math.min(lsf,price);
            profit=Math.max(profit,price-lsf);
        }
        return profit;
    }
}