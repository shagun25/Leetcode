class Solution {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int mod = 1_000_000_007;
        Arrays.sort(nums);
        
        // Precompute the value of 2 to the power of each value.
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; ++i) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        
        int answer = 0;
        int left = 0, right = n - 1;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                answer += power[right - left];
                answer %= mod;
                left++;
            } else {
                right--;
            }
        }
        
        return answer;
    }
}
// The window calculates the number of subsequences that must start with nums[left].
// [l = 0, r = 7] will contain all of the combinations [l = 1, r = 7], BUT appended with nums[0] in front.
// Therefore all the elements in [l = 0, r = 7] is unique from [l = 1, r = 7].
// remember that we must include the minimum (or at least 1) element in any subsequence in order to calc min+max???
// it means that we calculate subsequences with fixed [3] and variable [5,6]