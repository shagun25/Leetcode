class Solution {
    int MOD = 1000000007;
    int solve(int freq[][], String target,int wordIdx,int targetIdx,int dp[][]){
        if(targetIdx==target.length()) return 1;
        if(wordIdx==freq.length) return 0;
        if(dp[wordIdx][targetIdx]!=-1) return dp[wordIdx][targetIdx];
        int targetCh = target.charAt(targetIdx)-'a';
        int notPick = solve(freq,target,wordIdx+1,targetIdx,dp);
        int pick=0;
        if(freq[wordIdx][targetCh]!=0)
        {
            int currWays=freq[wordIdx][targetCh];
            int nextWays = solve(freq,target,wordIdx+1,targetIdx+1,dp);
            pick = (int)( currWays%MOD * (long)nextWays%MOD )%MOD;
        }
        
        dp[wordIdx][targetIdx]=(pick%MOD+notPick%MOD)%MOD;
        return dp[wordIdx][targetIdx];
    }
    public int numWays(String[] words, String target) {
        int dp[][] = new int[words[0].length()][target.length()];
        for(int d[] : dp)
        Arrays.fill(d,-1);
        
        int freq[][] = new int[words[0].length()][26];
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[0].length();j++){
                freq[j][words[i].charAt(j)-'a']++;
            }
        }
        // for(int f[]: freq){
        //     for(int x : f){
        //         System.out.print(x);
        //     }
        //     System.out.println();
        // }
        return solve(freq,target,0,0,dp);
    }
}