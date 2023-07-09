class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxSize = 0, countT = 0, countF = 0;
        for(int right = 0; right <answerKey.length(); right++){
            if(answerKey.charAt(right)=='T') countT++;
            else countF++;
            int minor = Math.min(countT,countF);
            if(minor <= k) maxSize++;
            else{
                if(answerKey.charAt(right - maxSize)=='T') countT--;
                else countF--;
            }
        }
       return maxSize; 
    }
}