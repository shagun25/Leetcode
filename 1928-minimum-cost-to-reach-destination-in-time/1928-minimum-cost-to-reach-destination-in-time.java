class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int N = passingFees.length;
        ArrayList<int[]>[] graph = new ArrayList[N];
        for(int i = 0; i < N ; i++) graph[i] = new ArrayList<>();
        
        for(int[] e : edges){
            int u = e[0], v = e[1], w = e[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        int[] timeHold = new int[N];
        Arrays.fill(timeHold, (int) 1e9);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[1] - b[1];
        });
        // vtx | cost | time 
        pq.add(new int[]{0, passingFees[0], 0});
        timeHold[0] = 0;
        while(!pq.isEmpty()){
            int[] p = pq.remove();
            int vtx = p[0], cost = p[1], time = p[2]; 
            if(vtx == passingFees.length - 1) return cost;
            for(int[] e : graph[vtx]){
                int v = e[0], n_time = e[1];
                if(time + n_time > maxTime) continue;
                if(time + n_time < timeHold[v]){
                    timeHold[v] = n_time + time;
                    pq.add(new int[]{v, cost + passingFees[v], timeHold[v]});
                }
            }
        }
        return -1;
    }
}