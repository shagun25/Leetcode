class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        Map<Integer, Integer> nm = new HashMap<>();
        int n=nums.length,val=0;
        long ans=n;
        for(int i=0;i<n;i++)
        {
            nm.put(nums[i],i);
        }
        Arrays.sort(nums);
        for(int i=0;i<n;i++)
        {
            if(nm.get(nums[i])<val)
            {
                ans+=n-i;
            }
            val=nm.get(nums[i]);
        }   
        return ans;
    }
}