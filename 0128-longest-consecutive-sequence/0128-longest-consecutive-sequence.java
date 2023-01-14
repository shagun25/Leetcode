class Solution {
    public int longestConsecutive(int[] nums) {
        // Approach: We will first push all are elements in the HashSet. Then we will run a for loop and check for any number(x) if it is the starting number of the consecutive sequence by checking if the HashSet contains (x-1) or not. If ‘x’ is the starting number of the consecutive sequence we will keep searching for the numbers y = x+1, x+2, x+3, ….. And stop at the first ‘y’ which is not present in the HashSet. Using this we can calculate the length of the longest consecutive subsequence. 
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