class Solution {
    int mini = Integer.MAX_VALUE;

    private void distributeCookiesHelp(int ind, int dp[], int cs[]) {
        if( ind == cs.length){
            int maxi = Integer.MIN_VALUE;
            for(int x : dp) maxi = Math.max(maxi, x);
            mini = Math.min(mini, maxi);
            return;
        }

        for(int i=0; i<dp.length; i++){
            dp[i] += cs[ind];
            distributeCookiesHelp(ind+1, dp, cs);
            dp[i] -= cs[ind];
        }
    }

    public int distributeCookies(int[] cs, int k) {
        int dp[] = new int[k];
        distributeCookiesHelp(0, dp, cs);
        return mini;
    }
}