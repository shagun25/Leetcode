class Solution {
    private long[] subtree_sum; //Stores -> If the tree was rooted at node 0 what is the maximum sum we can get from subtree of i
    private long max_dif = 0L;
    public long maxOutput(int n, int[][] edges, int[] price) {
        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0;i<n;i++) tree.add(new ArrayList<>());
        for(int[] e: edges){
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        subtree_sum = new long[n];
        dfs(0,-1,tree,price);  //Fills the subtree_sum array
        dfs2(0,-1,tree,price,0);
        return max_dif;
    }
    private long dfs(int node, int parent, List<List<Integer>> tree, int[] price){
        long m = 0L; //We need the maximum contribution of children. 
        for(int child: tree.get(node)){
            if(child == parent) continue;
            m  = Math.max(m, dfs(child,node,tree,price));
        }
        return subtree_sum[node] = price[node] + m;
    }
    private void dfs2(int node, int parent,List<List<Integer>> tree, int[] price, long parent_contribution){
        int c1=-1,c2=-1; 
        long mc1=0,mc2=0;  //2 maximum contribution of children
        for(int child: tree.get(node)){
            if(child == parent) continue;
            if(subtree_sum[child]>mc1){
                c2 = c1;
                mc2 = mc1;
                c1 = child;
                mc1 = subtree_sum[child];
            }
            else if(subtree_sum[child]>mc2){
                c2 = child;
                mc2 = subtree_sum[child];
            }
        }
        long path1 = mc1;
        long path2 = parent_contribution;
        max_dif = Math.max(max_dif,Math.max(path1,path2));
        for(int child: tree.get(node)){
            if(child == parent) continue;
/*
How can a parent add a path to child?
1. Take a path from a siblling of child     (we want the maximum siblling)
2. Take a path from its parent

Thus the contribution of current node to its child c is maximum(maximum siblling ,node's parent_contribution)
*/
            if(c1 == child) dfs2(child,node,tree,price,price[node]+Math.max(mc2,parent_contribution)); 
            else dfs2(child,node,tree,price,price[node]+Math.max(mc1,parent_contribution));
        }
    }
}