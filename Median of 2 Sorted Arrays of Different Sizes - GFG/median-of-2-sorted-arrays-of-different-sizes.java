//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int[] nums1,int[] nums2) 
    {
        boolean isEven = ((long)(m+n))%2==0?true:false;
        if(n<m) return findMedian(nums1,nums2,isEven);
        return findMedian(nums2,nums1,isEven);
    }
    static double findMedian(int[] nums1,int[] nums2,boolean isEven){
        int m = nums1.length,n=nums2.length;
        int l = 0, h=m;
        long N = m+n; 
        while(l<=h){
            int mid = l+(h-l)/2;
            int b = (int)(N+1)/2-mid;
            int mi = (mid==0)?Integer.MIN_VALUE:nums1[mid-1];
            int ml = (mid==m)?Integer.MAX_VALUE:nums1[mid];
            int bi = (b==0)?Integer.MIN_VALUE:nums2[b-1];
            int bl = (b==n)?Integer.MAX_VALUE:nums2[b];
        
            if(mi>bl) h=mid-1;
            else if(bi>ml) l=mid+1;
            else{
                int left = Math.max(mi,bi);
                int right = Math.min(ml,bl);
                if(!isEven) return left;
                return (double)(left+right)/2;
            }
        }
        return (double)0;
    }
}