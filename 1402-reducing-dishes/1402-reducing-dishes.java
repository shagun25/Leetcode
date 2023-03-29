class Solution {
    int recursion(int[] satisfaction,int memo[][],int index,int time){
        if(index==satisfaction.length) return 0;
        if(memo[index][time]!=-1){
            return memo[index][time];
        }
        return memo[index][time]=Math.max(satisfaction[index]*time+recursion(satisfaction,memo,index+1,time+1),recursion(satisfaction,memo,index+1,time));
    }
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int memo[][] = new int[satisfaction.length+1][satisfaction.length+1];
        for(int[] mem : memo){
            Arrays.fill(mem,-1);
        }
        return recursion(satisfaction,memo,0,1);
    }
}