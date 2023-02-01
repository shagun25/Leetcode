class Solution {
    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }    
    }
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int x : nums){
            min = Math.min(min,x);
            max = Math.max(max,x);
        }
        return gcd(min,max);
    }
}
