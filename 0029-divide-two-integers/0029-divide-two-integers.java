class Solution {
    public int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1; //Edge Case
       //if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231
        int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res; //sign case
    }
}
//TLE(naive)
//         dividend = 10, divisor = 3
//         10  7   4   1
//         3   3   3   3(stop)   res=3

// Explanation
// Step1   dividend = 10, divisor = 3
//         10  10  10
//         3   6   12(stop)   res+=2
// Step2   dividend = 4, divisor = 3
//         4  4
//         3  6(stop)   res+=1
// Step3   dividend = 1, divisor = 3
//         1
//         3(stop)   res+=0
// return res
    
    