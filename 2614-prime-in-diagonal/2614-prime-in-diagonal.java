class Solution {

    boolean isPrime(int n){
        if(n < 2)  return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0) return false;
        }
        return true;
    }
    public int diagonalPrime(int[][] nums) {
        int ans=Integer.MIN_VALUE;
        int n = nums.length;
        int i=0,j=0;
        while(i<n && j<n){
            if(ans<nums[i][j] && isPrime(nums[i][j]))
                ans=nums[i][j];
            i++;j++;
        }
        i=n-1;j=0;
        while(i<n && j<n){
            if(ans<nums[i][j] && isPrime(nums[i][j]))
                ans=nums[i][j];
            i--;j++;
        }
        return ans==Integer.MIN_VALUE?0:ans;
    }
}