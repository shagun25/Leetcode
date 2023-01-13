class Solution {
    public int maxProfit(int[] prices) {
        int op=0; //overall profit
        int pist=0; //profit if sold today
        int lsf=Integer.MAX_VALUE;//least so far
        for(int price :prices){
            if(lsf>price) lsf=price;
            pist=price-lsf;
            if(pist>op) op=pist;
        }
        return op;
    }
}