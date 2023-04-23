class Solution {
    int mod = 1_000_000_007;
    public int numberOfArrays(String s, int k) {
        int m = s.length();
        int[] dp = new int[m + 1];
        return recursion(s,0,k,dp);
    }
    int recursion(String s, int i,int k,int dp[]){
         // If we have already updated dp[i], return it.
        if (dp[i] != 0)
            return dp[i];

        // There is only 1 split for an empty string.
        if (i == s.length())
            return 1;

        // Number can't have leading zeros.
        if (s.charAt(i) == '0')
            return 0;
        
        long num=0;
        int count=0;
        for(int j=i;j<s.length();j++){
            int digit = s.charAt(j)-'0';
            num = num*10+digit;
            if(num>k) break;
            count=(count+recursion(s,j+1,k,dp))%mod;
        }
        dp[i]=count;
        return count;
    }
}