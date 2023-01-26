class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int[] f: flights){
            map.computeIfAbsent(f[0],value->new ArrayList<>()).add(new int[]{f[1],f[2]});
        }
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,0});
        int stops=0;
        while(stops<=k && !q.isEmpty()){
            int sz = q.size();
            while(sz-->0){
                int temp[] = q.poll();
                int node = temp[0],distance=temp[1];
                if(map.containsKey(node)){
                    for(int[] e:map.get(node)){
                        int v=e[0], wt=e[1];
                        if(wt+distance<dist[v]){
                            dist[v]=wt+distance;
                            q.add(new int[]{v,dist[v]});
                        }
                    }
                }
            }
            stops++;
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}