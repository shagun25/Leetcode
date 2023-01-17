//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int check(int[] weights, int mid){
        int sum=0;
        int count=0;
     for(int weight: weights){
         sum+=weight;
         if(sum>mid) {sum=weight;count++;}
     }
        return count;
    }
    static int leastWeightCapacity(int[] weights, int N, int days) {
       int max=Integer.MIN_VALUE,totalLoad=0;
        for(int weight: weights){
            totalLoad+=weight;
            max=Math.max(weight,max);
        }
    
        int low=max,high=totalLoad;
        while(low<high)
        {
            int mid=low+(high-low)/2;
            if(check(weights,mid)<days) high=mid;
            else low=mid+1;
        }
        return low;
    }
};