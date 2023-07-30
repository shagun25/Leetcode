class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        char charArray[] = s.toCharArray();
        int dp[][] = new int[n][n];
        for(int a[]: dp){
            Arrays.fill(a,-1);
        }
        return MCM(0,n-1,charArray,dp);
    }
    
    int MCM(int i,int j, char charArray[], int dp[][]){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
          char ch = charArray[i];
          int ans = 1+MCM(i+1,j,charArray,dp);
        for(int k=i+1;k<=j;k++){
            if(charArray[k]==ch){
               ans = Math.min(ans, MCM(i,k-1,charArray,dp)+MCM(k+1,j,charArray,dp)); 
            }
        }
        dp[i][j]=ans;
        return dp[i][j];
              
    }
}