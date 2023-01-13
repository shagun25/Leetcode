class Solution {
    int longestPath=1;
    int dfs(int node, int parent, Map<Integer,List<Integer>> children, char[] s){
        int longestChain=0,secondLongestChain=0;
        for(int child : children.get(node)){
            if(child!=parent){
                int longestPathfromthisChild = dfs(child,node,children,s);
            if(s[child]!=s[node]){
                if(longestPathfromthisChild>longestChain){
                    secondLongestChain=longestChain;
                    longestChain=longestPathfromthisChild;
                }else if(longestPathfromthisChild>secondLongestChain){
                    secondLongestChain=longestPathfromthisChild;
                }
            }
            }
        }
        longestPath = Math.max(longestPath, longestChain+secondLongestChain+1);
        return longestChain+1;
    }
    public int longestPath(int[] parent, String s) {
        Map<Integer,List<Integer>> children = new HashMap<>();
        int n = parent.length;
        if(n==1) return 1;
        for(int i=1;i<n;i++){
           children.computeIfAbsent(parent[i],value->new ArrayList<Integer>()).add(i);
           children.computeIfAbsent(i,value->new ArrayList<Integer>()).add(parent[i]);
        }
        dfs(0,-1,children,s.toCharArray());
        return longestPath;
    }
}