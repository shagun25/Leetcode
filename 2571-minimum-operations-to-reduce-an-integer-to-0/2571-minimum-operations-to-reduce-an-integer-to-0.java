class Solution {
    // 1. When n is even number, divide by 2 (operation no change)
    // 2. When n is odd number, operation count added by 1
    //    2.1 If n is 1 (base case) or last 2 digits of n is 01, minus n by 1
    //    2.3 else add n by 1.
    //    (The logic behind choose add 1 or minus 1, is how to make last 2 digit to 0)
    public int minOperations(int n) {
        int c=0;
        while(n>0){
            if(n%2==1){
                c++;
                if(n==1 || (n&2)==0) n-=1;
                else n+=1;
            }else{
                n=n/2;
            }
        }
        return c;
    }
}