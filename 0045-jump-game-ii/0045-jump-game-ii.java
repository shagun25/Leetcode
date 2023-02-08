class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length <2) return 0;
        
        int[] memData = new int[nums.length];
        memData[nums.length-1] = 0;
        
        for(int i=nums.length-1; i>=0; i--){ 
            if (i == nums.length -1)
                continue;
            if(nums[i] == 0){
                memData[i] = Integer.MAX_VALUE;
                continue;
            }
            
            int minSteps =  Integer.MAX_VALUE;
            int maxIndex = Math.min(nums.length-1, i+nums[i]);
            for(int j=i+1; j <= maxIndex; j++){
                minSteps = Math.min(minSteps, memData[j]);
            }
            memData[i] = (minSteps==Integer.MAX_VALUE)? Integer.MAX_VALUE: minSteps+1;
        }
        
        return memData[0];
    }
}