class TreeAncestor {
    int dp[][];
    public TreeAncestor(int n, int[] parent) {
        dp= new int[17][n+1];
        for(int d[]: dp){
            Arrays.fill(d,-1);
        }
        for(int i=0;i<parent.length;i++){
            dp[0][i]=parent[i];
        }
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                int fp=dp[i-1][j];
                if(fp!=-1)
                dp[i][j]=dp[i-1][fp];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int count=0; int ans=-1;
        while(k>0){
            if((k&1)==1){
                ans=dp[count][node];
                node=ans;
                if(node==-1) return -1;
            }
            count++;
            k=k>>1;
        }
        return ans;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */