class Solution {
    int bfs(HashMap<Integer,List<Integer>> map,boolean vis[],int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node]=true;
        int count=1;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(!map.containsKey(curr)) continue;
            for(int neighbour : map.get(curr)){
                if(!vis[neighbour]){
                    vis[neighbour]=true;
                    q.add(neighbour);
                    count++;
                }
            }
        }
        return count;
    }
    public long countPairs(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int edge[] : edges){
            map.computeIfAbsent(edge[0],k->new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1],k->new ArrayList<>()).add(edge[0]);
        }
        boolean vis[] = new boolean[n];
        long rem=n,pairs=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                long connectedComponentSize = bfs(map,vis,i);
                pairs+=connectedComponentSize*(rem-connectedComponentSize);
                rem-=connectedComponentSize;
            }
        }
        return pairs;
    }
}