class Solution {
    int[] dfs(int node, int parent, Map<Integer,List<Integer>> adj, int ans[], char label[]){
        int nodeCount[] = new int[26];
        nodeCount[label[node]-'a']=1;
        for(int child : adj.get(node)){
            if(child!=parent){
                int childCount[] = dfs(child,node,adj,ans,label);
                for(int i=0;i<26;i++){
                   nodeCount[i]+=childCount[i];
                }
            }
        }
        ans[node]=nodeCount[label[node]-'a'];
        return nodeCount;
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int edge[] :edges){
            int a = edge[0];int b = edge[1];
            adj.computeIfAbsent(a,value->new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b,value->new ArrayList<Integer>()).add(a);
        }
        int ans[] = new int[n];
        char label[] = labels.toCharArray();
        dfs(0,-1,adj,ans,label);
        return ans;
    }
}

