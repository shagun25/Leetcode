class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long ans = 0;
        long low = 0, high = 0;

        for (int i = 0; i < batteries.length; i++) {
            high += batteries[i];
        }

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (ispossible(batteries, mid, n)) {
                ans = mid;//3
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        return ans;
    }
    //n = 2, batteries = [1,1,1,1], mid=2
    public boolean ispossible(int batteries[], long mid, int n) {
        long total = 0L;
   
        for (long batt : batteries) {
            if (batt < mid) {
                total += batt; //  total+=4
            } else {
                total += mid; //
            }
        }
    
        return (total >= mid * n);//4>=4
    }

}