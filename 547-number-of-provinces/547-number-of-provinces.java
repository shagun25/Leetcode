class Solution {
    int parent[],rank[];
    void union(int x,int y){
        int x_rep = find(x);
        int y_rep = find(y);
        
        if(x_rep==y_rep) return;
        
        if(rank[x_rep]>rank[y_rep]){
            parent[y_rep]=x_rep;
        }else if(rank[x_rep]>rank[y_rep]){
            parent[x_rep]=y_rep;
        }else{
            parent[x_rep]=y_rep;
            rank[x_rep]++;
        }
    }
    int find(int x){
        if(parent[x]==x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        int e = isConnected[0].length;
        
        parent = new int[v];
        rank = new int[v];
        for(int i=0;i<v;i++){
            parent[i]=i;
            rank[i]=0;
        }
        
        for(int i=0;i<v;i++){
            for(int j=0;j<e;j++){
                if(i!=j && isConnected[i][j]==1) union(i,j);
            }
        }
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<v;i++){
            set.add(find(i));
        }
        return set.size();
    }
}