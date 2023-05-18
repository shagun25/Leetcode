class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int arr[] = new int[n];
        List<Integer> list = new ArrayList<>();
        for(List<Integer> t : edges){
            arr[t.get(1)]++;
        }
        for(int i=0;i<n;i++){
            if(arr[i]==0) list.add(i);
        }
        return list;
    }
}