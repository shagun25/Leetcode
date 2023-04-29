class UnionFind{
    private int parent[];
    private int rank[];
    UnionFind(int N){
        parent = new int[N];
        for(int i=0;i<N;i++) parent[i]=i;
        rank = new int[N];
    }
    public int find(int x){
        if(parent[x]!=x) parent[x]=find(parent[x]);
        return parent[x];
    }
    public void union(int x,int y){
        int x_set = find(x);
        int y_set = find(y);
        if(x_set==y_set) return;
        if(rank[x_set]>rank[y_set]) parent[y_set]=x_set;
        else if(rank[x_set]<rank[y_set]) parent[x_set]=y_set;
        else{
            parent[x_set]=y_set;
            rank[y_set]++;
        }
    }
    public boolean areConnected(int x, int y){
        int x_set = find(x);
        int y_set = find(y);
        return x_set==y_set;
    }
}
class Solution {
    private void sort(int[][] array) {
        Arrays.sort(array, new Comparator<int[]>() {
          @Override
          public int compare(int[] a, int[] b) {
            return a[2] - b[2];
          }
        });
    }    
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        UnionFind dsu = new UnionFind(n);
        int queriesCount = queries.length;
        boolean ans[] = new boolean[queriesCount];
        int queriesWithIndex[][] = new int[queriesCount][4];
        for(int i=0;i<queriesCount;i++){
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = queries[i][2];
            queriesWithIndex[i][3] = i;
        }
        
        sort(edgeList);
        sort(queriesWithIndex);
        
        int edgeIndex=0;
        for(int queryIndex=0;queryIndex<queriesCount;queryIndex++){
            int p = queriesWithIndex[queryIndex][0];
            int q = queriesWithIndex[queryIndex][1];
            int limit = queriesWithIndex[queryIndex][2];
            int queryOriginalIndex = queriesWithIndex[queryIndex][3];
            
            while(edgeIndex<edgeList.length && edgeList[edgeIndex][2]<limit){
                int node1 = edgeList[edgeIndex][0];
                int node2 = edgeList[edgeIndex][1];
                dsu.union(node1,node2);
                edgeIndex++;
            }
            ans[queryOriginalIndex] = dsu.areConnected(p,q);
        }
        return ans;
    }
}