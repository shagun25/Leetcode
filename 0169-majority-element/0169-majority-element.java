class Solution {
    public int majorityElement(int[] nums) {
        // Boyer-Moore Voting Algorithm
        int candidate=0,count=0;
        for(int x: nums){
            if(count==0){
                candidate=x;
            }
            count+=(x==candidate)?1:-1;
        }
        return candidate;
    }
}