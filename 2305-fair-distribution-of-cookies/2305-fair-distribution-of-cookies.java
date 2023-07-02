class Solution {
    int ans=Integer.MAX_VALUE;
    public void backtrackfun(int i, int cookies[], int bag[]){
        if(i==cookies.length){
            int maxi=0;
            for(int k=0;k<bag.length;k++){
                maxi=Math.max(maxi,bag[k]);
            }
            ans=Math.min(ans,maxi);
            return;
        }
        for(int k=0;k<bag.length;k++){
            bag[k]=bag[k]+cookies[i];
            backtrackfun(i+1,cookies,bag);
            bag[k]=bag[k]-cookies[i];
        }
    }
    public int distributeCookies(int[] cookies, int k) {
        int bag[]=new int[k];
        backtrackfun(0,cookies,bag);
        return ans;
    }
}