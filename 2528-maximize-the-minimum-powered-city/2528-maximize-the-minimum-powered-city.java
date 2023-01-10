class Solution {
    boolean check(long[] ans, long mid, int r, int k){
        long sum=0;
        int n=ans.length;
        for(int i=0;i<r;i++)
            sum+=ans[i];
        for(int i=0;i<n;i++){
            sum+=((i+r<=n-1)?ans[i+r]:0)-((i-r-1>=0)?ans[i-r-1]:0);
            if(sum<mid){
                    if((mid-sum)>k)
                        return false;
                if(i+r<=n-1) ans[i+r]+=(mid-sum);
                k-=(mid-sum);
                sum=mid;
            }
        }
        return true;
    }
    public long maxPower(int[] stations, int r, int k) {
        long l=0;
        long h=k;
        int n=stations.length;
        for(int i=0;i<n;i++)
            h+=(long)stations[i];
   
        while(l<h){
            long mid=h+(l-h)/2;
            long[] ans = new long[n];
            for(int i=0;i<n;i++)
            ans[i]=stations[i];
            if(check(ans,mid,r,k)) l=mid;
            else h=mid-1;
        }
        return l;
    }
}