class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if((i==0) || (i>0 && nums[i]!=nums[i-1])){
                int sum = -nums[i];
                int lo = i+1,hi = nums.length-1;
                while(lo<hi){
                    if(nums[lo]+nums[hi]==sum){
                        res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                        while(lo<hi && nums[hi]==nums[hi-1]) hi--;
                        lo++;
                        hi--;
                    }else if(nums[lo]+nums[hi]>sum) hi--;
                    else lo++;
                }
            }
        }
        return res;
    }
}