class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        // Advance Boyer Moore Voting Algorithm
        int candidate1=0,candidate2=0,count1=0,count2=0;
        for(int x: nums){
            if(x==candidate1) count1++;
            else if(x==candidate2) count2++;
            else if(count1==0) {candidate1=x;count1=1;}
            else if(count2==0) {candidate2=x;count2=1;}
            else{
                count1--;count2--;
            }
        }
        if(count1==0 && count2==0) return new ArrayList<>();
       count1=0;count2=0;
        for(int x: nums){
            if(x==candidate1) count1++;
            else if(x==candidate2) count2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(count1>(n/3)) ans.add(candidate1);
        if(count2>(n/3)) ans.add(candidate2);
        return ans;
    }
}