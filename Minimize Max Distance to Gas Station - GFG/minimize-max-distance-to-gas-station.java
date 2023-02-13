//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      int k = sc.nextInt();
      Solution obj = new Solution();
      double ans = obj.findSmallestMaxDist(a,k);
      System.out.printf("%.2f",ans);
      System.out.println();
    }
  }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
  public static double findSmallestMaxDist(int stations[],int K) {
    int count;
    int N = stations.length;
    double left = 0, right = stations[N-1] - stations[0];
    while (right - left > 1e-6) {
      double mid = (left + right) / 2;
      count = 0;
      for (int i = 0; i < N-1; i++) {
        count += (int)((stations[i+1] - stations[i]) / mid);
      }
      if (count > K) left = mid;
      else right = mid;
    }
    return right;
  }
}
     