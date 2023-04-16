class Solution {
    int solve(List<List<Integer>> piles, int k, int idx, int dp[][]){
        int n = piles.size();
        if(idx>=n) return 0;
        if(dp[idx][k]!=-1) return dp[idx][k];
        int not_taken = solve(piles,k,idx+1,dp);
        int taken=0;
        int sum=0;
        for(int j=0;j<Math.min(piles.get(idx).size(),k);j++){
            sum+=piles.get(idx).get(j);
            taken = Math.max(taken,sum+solve(piles,k-(j+1),idx+1,dp));
        }
        return dp[idx][k]=Math.max(taken,not_taken);
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int dp[][] = new int[piles.size()][k+1];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        return solve(piles,k,0,dp);
    }
}