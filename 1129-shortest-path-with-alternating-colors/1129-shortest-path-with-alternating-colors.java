class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int g[][] = new int[n][n];
        buildGraph(g,n,redEdges,blueEdges);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,1});
        q.add(new int[]{0,-1});
        HashSet<String> set = new HashSet<>();
        set.add("0 1");
        set.add("0 -1");
        int steps=0;
        int res[] = new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[0]=0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] curr = q.poll();
                int u = curr[0];
                int c = curr[1];
                for(int j=0;j<n;j++){
                    if(g[u][j]==-c || g[u][j]==0) {
                        if(!set.add(j+" -"+c)) continue;
                        q.add(new int[]{j,-c});
                        res[j]=Math.min(res[j],steps+1);
                    }
                }
            }
            steps++;
        }
        for(int i=0;i<n;i++){
            if(res[i]==Integer.MAX_VALUE) res[i]=-1;
        }
        return res;
    }
    void buildGraph(int g[][], int n, int[][] redEdges, int[][] blueEdges){
        for(int i=0;i<n;i++) Arrays.fill(g[i],-n);
        for(int edge[] : redEdges){
            int u = edge[0];
            int v = edge[1];
            g[u][v]=1;
        }
        for(int edge[] : blueEdges){
            int u = edge[0];
            int v = edge[1];
            if(g[u][v]==1) g[u][v]=0;
            else g[u][v]=-1;
        }
    }
}