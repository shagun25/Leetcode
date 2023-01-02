class Solution {
    public int minimumPartition(String s, int k) {
   int digit=0;
        long value=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            digit = s.charAt(i);
            digit-=48;
            if(digit>k) return -1;
            value=value*10+digit;
            if(value>k){
                count++;
                value=digit;
            }
        }
        if(value<=k) count++;
        return count;
    }
}