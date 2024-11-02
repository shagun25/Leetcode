class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
         int m = str1.length(), n = str2.length();
            
            int dp[][] = new int[m+1][n+1];
            
            for(int i=1; i<=m; i++)
            {
                for(int j=1; j<=n; j++)
                {
                    
                    if(str1.charAt(i-1)==str2.charAt(j-1))
                        dp[i][j] = 1 + dp[i-1][j-1];
                    else
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
            
           int i=m,j=n;
        String str="";
          while(i>0 && j>0){
              if(str1.charAt(i-1)==str2.charAt(j-1)){
                  str=str1.charAt(i-1)+str;
                  i--;j--;
              }else if(dp[i-1][j]>dp[i][j-1]){
                  str=str1.charAt(i-1)+str;
                  i--;
              }else{
                  str=str2.charAt(j-1)+str;
                  j--;
              }
          }
        while(i>0){
            str=str1.charAt(i-1)+str;
            i--; 
        }
        while(j>0){
            str=str2.charAt(j-1)+str;
            j--;
        }
return str;
    }
}