class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        solve(1,n,k,new ArrayList<Integer>());
        return ans;
    }
    void solve(int start, int n, int k, List<Integer> list){
        if(start>n || list.size()==k){
            if(list.size()==k){
                ans.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for(int i=start;i<=n;i++){
            list.add(i);
            solve(i+1,n,k,list);
            list.remove(list.size()-1);
        }
    }
}