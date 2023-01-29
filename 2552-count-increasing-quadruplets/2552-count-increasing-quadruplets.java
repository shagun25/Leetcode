class Solution {
    public long countQuadruplets(int[] nums) {
         int n = nums.length;
         int lessThan[][] = new int[n+1][n+1];
        //lessThan[i][j] -> no. of elements less than i in first j elements

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                lessThan[i][j] = lessThan[i][j-1] + ((nums[j-1] < i)?1:0);
            }
        }

        long res = 0;
        for (int j = 0; j < n; j++) {
            for (int k = j+1; k < n; k++) {
                if (nums[k] < nums[j]) {
                    long potentialI = lessThan[nums[k]][j];
                    //lessThan[nums[j]][k+1]-> no of ele less than nums[j] present at index k+1
                    //element greater than nums[j] and index <= k
                    //k - lessThan[nums[j]][k+1] = ele greater than nums[j] and indx < k
                    long potentialL = (n - nums[j]) - (k - lessThan[nums[j]][k+1]);
                    res += potentialI * potentialL;
                }
            }
        }
        return res;
    }
}