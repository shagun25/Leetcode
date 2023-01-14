//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int n, int nums[]){
        int ind1=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]) {ind1=i;break;}
        }
        if(ind1!=-1){
           int ind2=0;
           for(int i=n-1;i>=0;i--){
              if(nums[i]>nums[ind1]) {ind2=i;break;}
           }
            swap(nums,ind1,ind2);
        }
      
        reverse(nums,ind1+1,n-1);
        List<Integer> list = new ArrayList<>();
        for(int x:nums) list.add(x);
        return list;
    }
    static void swap(int[] nums,int ind1,int ind2){
        int temp = nums[ind1];
        nums[ind1]=nums[ind2];
        nums[ind2]=temp;
    }
    static void reverse(int[] nums,int i,int j){
        while(i<j)
            swap(nums,i++,j--);
    }
}