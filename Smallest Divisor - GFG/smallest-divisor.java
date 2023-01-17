//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int check(int[] nums, int mid){
        int sum=0;
        for(int num: nums){
            sum+=(int)Math.ceil((double)num/mid);
        }
        return sum;
    }
    public static int smallestDivisor(int[] nums, int K) {
        int max=Integer.MIN_VALUE;
        for(int num: nums){
            max=Math.max(num,max);
        }
    
        int low=1,high=max;
        while(low<high)
        {
            int mid=low+(high-low)/2;
            if(check(nums,mid)<=K) high=mid;
            else low=mid+1;
        }
        return low;
    }
}