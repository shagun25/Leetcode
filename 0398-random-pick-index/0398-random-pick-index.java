class Solution {
    
    private int[] nums;
    private Random rand;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int pick(int target) {
        List<Integer> indices = new ArrayList<>();
        int n = this.nums.length;
        int count = 0;
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            if (this.nums[i] == target) {
                indices.add(i);
            }
        }
        int l = indices.size();
        // pick an index at random
        int randomIndex = indices.get(rand.nextInt(l));
        return randomIndex;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */