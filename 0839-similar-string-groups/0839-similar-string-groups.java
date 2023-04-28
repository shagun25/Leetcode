class UnionFind{
    int parent[];
    int rank[];
    UnionFind(int size){
        parent = new int[size];
        for(int i=0;i<size;i++) parent[i]=i;
        rank = new int[size];
    }
    int find(int x){
        if(parent[x]!=x) parent[x]=find(parent[x]);
        return parent[x];
    }
    void union(int x, int y){
        int xset = find(x),yset = find(y);
        if(xset==yset) return;
        else if(rank[xset]<rank[yset]) parent[xset]=yset;
        else if(rank[xset]>rank[yset]) parent[yset]=xset;
        else{
            parent[yset]=xset;
            rank[xset]++;
        }
    }
}
    class Solution {
    boolean areSimilar(String a,String b){
        int diff=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) diff++;
        }
        return diff==0 || diff==2;
    }
    public int numSimilarGroups(String[] strs) {
        int n= strs.length;
        UnionFind dsu = new UnionFind(n);
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(areSimilar(strs[i],strs[j]) && dsu.find(i)!=dsu.find(j)) {
                    count++;
                    dsu.union(i, j);
                }
            }
        }
        return n-count;
    }
}