class Solution {
    long solve(int[][] questions,int i,long dp[]){
        if (i >= questions.length) return 0;
        if(dp[i]!=0) return dp[i];
        dp[i]=Math.max((long)questions[i][0]+solve(questions,i+questions[i][1]+1,dp),solve(questions,i+1,dp));
        return dp[i];
    }
    public long mostPoints(int[][] questions) {
        long dp[] = new long[questions.length];
        return solve(questions,0,dp);
    }
}