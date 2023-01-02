class Solution {
    public int countDigits(int num) {
        int number = num;
        int count=0;
       
        while(number>0){
            int divisible = number%10;
            if(num%divisible==0) {
                count++;
            }
            number=number/10;
        }
        return count;
    }
}