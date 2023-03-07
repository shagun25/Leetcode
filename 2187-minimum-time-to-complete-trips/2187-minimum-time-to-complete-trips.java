class Solution {
    long bs(int[] time,long mid){
        long sum=0;
        for(int t: time){
           sum+=mid/t;
        }
        return sum;
    }
    public long minimumTime(int[] time, int totalTrips) {
        int max_time = 0;
        for (int t : time) {
            max_time = Math.max(max_time, t);
        }
        long l = 1, h = (long) max_time*totalTrips;
        while(l<h){
            long m = l+(h-l)/2;
            long res = bs(time,m);
            if(res>=totalTrips) {
                h = m;
            }
            else l=m+1;
        }
        return l;
    }
}