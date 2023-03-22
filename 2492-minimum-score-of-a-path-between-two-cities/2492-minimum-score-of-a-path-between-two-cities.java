class Solution {
    int ans;
    void bfs(Map<Integer,List<List<Integer>>> map,int n){
        boolean vis[] = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1]=true;
        while(!q.isEmpty()){
            int node = q.poll();
            if(!map.containsKey(node)) continue;
            for(List<Integer> list: map.get(node)){
                ans=Math.min(ans,list.get(1));
                if(!vis[list.get(0)]){
                    q.add(list.get(0));
                    vis[list.get(0)]=true;
                }
            }
        }
    }
    public int minScore(int n, int[][] roads) {
        ans=Integer.MAX_VALUE;
      Map<Integer,List<List<Integer>>> map = new HashMap<>();
        for(int road[]:roads){
            map.computeIfAbsent(road[0],k->new ArrayList<List<Integer>>()).add(Arrays.asList(road[1],road[2]));
            map.computeIfAbsent(road[1],k->new ArrayList<List<Integer>>()).add(Arrays.asList(road[0],road[2]));
        }
        bfs(map,n);
        return ans;
    }
}