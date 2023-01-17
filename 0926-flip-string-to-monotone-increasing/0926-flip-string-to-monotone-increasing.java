class Solution {
    public int minFlipsMonoIncr(String s) {
        // flipCount= min(0->1   flipCount, 1->0.  number of count1 till here)
        int flipCount=0,count1=0;
        for(char ch : s.toCharArray()){
            if(ch=='1') count1++;
            else flipCount++;
            flipCount=Math.min(count1,flipCount);
        }
        return flipCount;
    }
}