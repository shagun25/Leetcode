public class Solution {

    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;
        if (nums.length == 5) return 1;
        
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int min4 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int max4 = Integer.MIN_VALUE;
        for (int val : nums) {
            if (min1 > val) {
                min4 = min3;
                min3 = min2;
                min2 = min1;
                min1 = val;
            } else if (min2 > val) {
                min4 = min3;
                min3 = min2;
                min2 = val;
            } else if (min3 > val) {
                min4 = min3;
                min3 = val;
            } else if (min4 > val) {
                min4 = val;
            }

            if (max1 < val) {
                max4 = max3;
                max3 = max2;
                max2 = max1;
                max1 = val;
            } else if (max2 < val) {
                max4 = max3;
                max3 = max2;
                max2 = val;
            } else if (max3 < val) {
                max4 = max3;
                max3 = val;
            } else if (max4 < val) {
                max4 = val;
            }
        }

        int[] minmax = new int[] {min1, min2, min3, min4, max4, max3, max2, max1};

        int left = 0;
        int right = minmax.length - 4;
        int diff = minmax[right] - minmax[left];
        for (int i = 0; i < 3; i++) {
            diff = Math.min(diff, minmax[++right] - minmax[++left]);
        }

        return diff;
    }
}