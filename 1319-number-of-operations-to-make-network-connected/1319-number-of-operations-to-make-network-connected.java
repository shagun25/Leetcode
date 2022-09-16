class Solution {
       int rank[],parent[];
    void union(int x,int y){
        int x_rep=find(x);
        int y_rep=find(y);
        if(x_rep==y_rep) return;
        if(rank[x_rep]>rank[y_rep]) parent[y_rep]=x_rep;
        else if(rank[x_rep]<rank[y_rep]) parent[x_rep]=y_rep;
        else{
           parent[y_rep]=x_rep;
            rank[x_rep]++;
        }
    }
    int find(int x){
        if(x==parent[x]) return x;
        parent[x]=find(parent[x]);
        return parent[x];
    }
    public int makeConnected(int n, int[][] connections) {
         if (connections.length < n - 1) return -1; 
       parent = new int[n]; 
       rank = new int[n]; 
       for(int i=0;i<n;i++){
           parent[i]=i;
       }
        int extraCables=0;
        for(int i=0;i<connections.length;i++){
            int a=connections[i][0];
            int b=connections[i][1];
            if(find(a)!=find(b)) union(a,b);
            else extraCables++;
        }
        int components =0;
        for(int i=0;i<n;i++){
           if(parent[i]==i) components++;
       }
        if(components-1<=extraCables) return components-1;
        return -1;
    }
}