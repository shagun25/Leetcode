class Solution {
    boolean good(int[] dist, double hr, int h) {
        double cnt = 0;
        for(int i = 0; i < dist.length-1; i++)
            cnt += Math.ceil(((double) dist[i])/h);
        cnt+=((double) dist[dist.length-1])/h;
        return cnt <= hr;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if(hour<=(double)(n-1)) return -1;
        int l = 1, h = Integer.MAX_VALUE,ans=0;
        while(l<=h){
            int m = l+(h-l)/2;
            if(good(dist,hour,m)){
                ans=m;
                h=m-1;
            }else l=m+1;
        }
        return ans;
    }
}