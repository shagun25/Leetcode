class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            if(!map.containsKey(target-x)) map.put(x,i);
            else return new int[]{map.get(target-x),i};
        }
        return new int[]{};
    }
}