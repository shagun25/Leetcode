class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recur(res,n,0,0,"");
        return res;
    }
    void recur(List<String> res,int n,int open,int close,String curr){
        if(curr.length()==n*2) res.add(curr);
        if(open<n) recur(res,n,open+1,close,curr+"(");
        if(close<open) recur(res,n,open,close+1,curr+")");    
    }
}