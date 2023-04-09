class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int indegree[] = new int[n];
        HashMap<Integer, List<Integer> > map = new HashMap<>();
        for(int edge[] : edges){
            map.computeIfAbsent(edge[0],k->new ArrayList<Integer>()).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count[][] = new int[n][26];
        int freq=1,cnt=0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            freq=Math.max(freq,++count[node][colors.charAt(node)-'a']);
            if(!map.containsKey(node)) continue;
            for(int neighbour : map.get(node)){
                for(int i=0;i<26;i++){
                   count[neighbour][i]=Math.max(count[node][i],count[neighbour][i]);
                }
                indegree[neighbour]--;
                if(indegree[neighbour]==0) q.add(neighbour);
            }
        }
        return cnt<n?-1:freq;
    }
}