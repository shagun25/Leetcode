//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkDays(int N, int[] bloomDay,long mid,int m,int k){
        int bqCount=0,adj=0;
        for(int i=0;i<N;i++)
            {
                if(bloomDay[i]>mid) adj=0;
                else{
                    adj++;
                    if(adj==k){
                        adj=0;
                        bqCount+=1;
                    }
                    if(bqCount>=m) break;
                }
            }
            return bqCount;
    }
    public static int solve(int m, int k, int[] bloomDay) {
        int N = bloomDay.length;
        
        if((long)m*k>N) return -1;
        
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int day: bloomDay){
            max=Math.max(day,max);
            min=Math.min(day,min);
        }
        
        int low=min,high=max;
        while(low<high)
        {
            int mid=low+(high-low)/2;
            if(checkDays(N,bloomDay,mid,m,k)<m) low=mid+1;
            else high=mid;
        }
        return low;
    }
}