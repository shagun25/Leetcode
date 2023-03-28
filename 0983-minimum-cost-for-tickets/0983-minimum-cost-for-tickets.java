class Solution {
    public int mincostTickets(int[] days, int[] cost) {
        int dp[] = new int[366];
        HashSet<Integer> set = new HashSet<>();
        for(int day:days){
            set.add(day);
        }
        for(int i=1;i<=365;i++){
            if(!set.contains(i)){
                dp[i]=dp[i-1];
            }else{
                dp[i]=Math.min(Math.min(dp[i-1]+cost[0],dp[Math.max(0,i-7)]+cost[1]),dp[Math.max(0,i-30)]+cost[2]);
            }
        }
        return dp[365];
    }
}