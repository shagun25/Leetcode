class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int memo[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            memo[i][0]=0;
        }
        for(int j=0;j<=n;j++){
            memo[0][j]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) memo[i][j]=1+memo[i-1][j-1];
                else memo[i][j]=Math.max(memo[i-1][j],memo[i][j-1]);
            }
        }
        return m+n-2*memo[m][n];
    }
}