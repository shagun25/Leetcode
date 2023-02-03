class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int ageScorePair[][] = new int[n][2];
        for(int i=0;i<n;i++){
            ageScorePair[i][0]=ages[i];
            ageScorePair[i][1]=scores[i];
        }
        Arrays.sort(ageScorePair,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        return maxScore(ageScorePair);
    }
    int maxScore(int[][] ageScorePair){
        int dp[]=new int[ageScorePair.length];
        for(int i=0;i<ageScorePair.length;i++){
            dp[i]=ageScorePair[i][1];
        }
        int answer=0;
        for(int i=0;i<ageScorePair.length;i++){
            for(int j=i-1;j>=0;j--){
                if(ageScorePair[i][1]>=ageScorePair[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+ageScorePair[i][1]);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}