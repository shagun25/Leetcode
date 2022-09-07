class adjNode{
    int v;
    int wt;
    adjNode(int v,int wt){
        this.v = v;
        this.wt = wt;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<adjNode> adjList[] = new ArrayList[n+1];
        for(int time[] : times){
            if(adjList[time[0]]==null) adjList[time[0]] = new ArrayList<adjNode>();
            adjList[time[0]].add(new adjNode(time[1],time[2]));
        }
        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dijkshtra(adjList,dist,n,k);
   
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dist[i]);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    void dijkshtra(ArrayList<adjNode> adjList[],int dist[],int n,int k){
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->(a[0]-b[0]));
        dist[k]=0;
        pq.add(new int[]{0,k});
        while(!pq.isEmpty()){
            int pair[] = pq.poll();
            int u = pair[1];
            int currNodeTime = pair[0];
            if (currNodeTime > dist[u]) {
                continue;
            }
            
            if (adjList[u]==null) {
                continue;
            }
            for (adjNode node : adjList[u]) {
                int wt = node.wt;
                int v = node.v;
                
                if (dist[v] > dist[u] + wt) {
                    dist[v] = dist[u] + wt;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }
    }
}