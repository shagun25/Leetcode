class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prev=new int[n];
        Arrays.fill(prev,Integer.MAX_VALUE);
        prev[src]=0;
        for(int i=0;i<=k;i++)
        {
            int[] curr= Arrays.copyOf(prev,n);
            for(int[] f: flights)
            {
                int u=f[0],v=f[1],wt=f[2];
                if(prev[u]==Integer.MAX_VALUE)
                    continue;
                if(curr[v]>prev[u]+wt)
                curr[v]=prev[u]+wt;
            }
            prev=curr;
        }
        return prev[dst]==Integer.MAX_VALUE?-1:prev[dst];
    }
}