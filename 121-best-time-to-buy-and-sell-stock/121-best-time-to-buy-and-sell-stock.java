class Solution {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int maxP = 0;
        int pist=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<lsf) lsf=prices[i];
            pist=prices[i]-lsf;
            maxP=Math.max(maxP,pist);
        }
        return maxP;
    }
}