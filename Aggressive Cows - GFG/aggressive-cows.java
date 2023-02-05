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

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static boolean check(int n, int k, int[] stalls,int ans){
        int cord=stalls[0];
        k--;
        for(int i=1;i<n;i++){
            if(stalls[i]-cord>=ans){
                cord=stalls[i];
                k--;
            }
        }
        if(k<=0)return true;
        return false;
    }
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);

        int low=1,high=stalls[n-1]-stalls[0];
        while(low<=high){
             int mid = (low + high) >> 1;
            if(check(n,k,stalls,mid)) {
                low=mid+1;
            }else high=mid-1;
        }
        return high;
    }
}