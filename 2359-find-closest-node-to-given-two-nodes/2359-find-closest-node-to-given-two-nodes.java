class Solution {
    void bfs(int[] edges, int startNode, int dist[]){
        boolean vis[] = new boolean[edges.length];
        Arrays.fill(vis, Boolean.FALSE);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        dist[startNode] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            if(!vis[node]){
                vis[node]=true;
                int neighbour = edges[node];
                if(neighbour!=-1 && !vis[neighbour]){
                    dist[neighbour]=1+dist[node];
                    q.add(neighbour);
                }
            }
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int dist1[]=new int[n],dist2[]=new int[n];
        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);
        bfs(edges,node1,dist1);
        bfs(edges,node2,dist2);
        int minDistNode=-1,minDistTillNow=Integer.MAX_VALUE;
        for(int currNode=0;currNode<n;currNode++){
            if(minDistTillNow>Math.max(dist1[currNode],dist2[currNode])){
                minDistTillNow=Math.max(dist1[currNode],dist2[currNode]);
                minDistNode=currNode;
            }
        }
        return minDistNode;
    }
}