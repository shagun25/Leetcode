class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return 1;
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        
        int maxStreak=0;
        for(int i=0;i<n;i++){
           if(!set.contains(nums[i]-1)){
               int currElement=nums[i];
               int currentStreak=1;
               while(set.contains(currElement+1)){
                   currentStreak+=1;
                   currElement+=1;
               }
               maxStreak=Math.max(maxStreak,currentStreak);
           }  
        }
        
        return maxStreak;
    }
}