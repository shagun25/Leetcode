class Solution {
    public int majorityElement(int[] nums) {
        // Boyer-Moore Voting Algorithm
        int candidate=0,count=0;
        for(int x: nums){
            if(x==candidate) count++;
            else if(count==0){
                candidate=x;
                count=1;
            }
            else count--;
        }
        return candidate;
    }
}