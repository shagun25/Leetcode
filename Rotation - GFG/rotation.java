//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        int index = findMin(arr,n);
        return index;
    }
    int findMin(int nums[], int n)
    {
        if(n==1) return 0;
        if(nums[0]<nums[n-1]) return 0;
        int l=0,h=n-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(nums[m]>nums[m+1]) return m+1;
            else if(nums[m-1]>nums[m]) return m;
            else if(nums[l]<=nums[m]) l=m+1;
            else h=m-1;
        }
        return -1;
    }
}