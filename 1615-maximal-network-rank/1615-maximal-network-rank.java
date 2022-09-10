class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        if(roads.length==0) return 0;
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++)  if(graph[i]==null) graph[i] = new ArrayList<Integer>();
        for(int road[] : roads){
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                res = Math.max(graph[i].size()+graph[j].size()-(isConnected(graph,i,j)?1:0),res);
                System.out.println(i+" "+j+"---->"+res);
            }
        }
        return res;
    }
    boolean isConnected(ArrayList<Integer> graph[],int i,int j){
        boolean g1=false,g2=false;
        for(Integer g : graph[i]) if(g==j) {g1=true;break;}
        for(Integer g : graph[j]) if(g==i) {g2=true;break;}
        return g1 && g2;
    }
}