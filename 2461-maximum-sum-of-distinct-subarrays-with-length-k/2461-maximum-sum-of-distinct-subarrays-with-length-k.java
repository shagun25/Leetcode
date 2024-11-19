class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        long maxSum = 0,sum=0;
        for(int i=0;i<k;i++){
             sum+=nums[i];
             map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        
          if(map.size()==k) maxSum=Math.max(maxSum,sum);
        
        System.out.println("sum: "+sum+", maxSum: "+maxSum);
        
        for(int i=k;i<nums.length;i++){
            sum+=nums[i]-nums[i-k];
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            map.put(nums[i-k], map.getOrDefault(nums[i-k],0)-1);
           if(map.get(nums[i-k])==0) map.remove(nums[i-k]);
           if(map.size()==k) maxSum=Math.max(maxSum,sum);
            System.out.println("sum: "+sum+", maxSum: "+maxSum);
        }
        return maxSum;
    }
}

 // 1 1 1 7 8 9
 // 1 1 1    sum=3, maxSum=0, set=[1]
 // 1 1 7    sum=9, maxSum=0, set=[1,7]
 // 1 7 8    sum=16, maxSum=16, set=[7,8]
 // 7 8 9    sum=24, maxSum=24, set=[7,8,9]