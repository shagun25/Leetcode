class Solution {
    public int maximumCandies(int[] candies, long k) {
         int max_candy = 0;
        long sum=0;
        for (int candy : candies) {
            max_candy = Math.max(max_candy, candy);
            sum+=candy;
        }
        if(sum<k) return 0;
        int l = 1, h = max_candy,ans=0;
        while(l<=h){
            int m = l+(h-l)/2;
            long res = bs(candies,m);
            if(res>=k) {
                ans=m;
                l=m+1; 
            }
            else {
                h = m-1;
            }
        }
        return ans;
    }
    long bs(int[] candies,long mid){
        long sum=0;
        for(int c: candies){
           sum+=(c/mid);
        }
        return sum;
    }
}