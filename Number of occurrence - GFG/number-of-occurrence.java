//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        int res[] = searchRange(arr,x);
        if(res[0]==-1 && res[1]==-1) return 0;
        return res[1]-res[0]+1;
    }
    public int[] searchRange(int[] nums, int target) {
        int l=0,h=nums.length-1,left=-1,right=-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(nums[m]==target){
                    int i=m;
                    while(i>0 && nums[i]==nums[i-1]) i--;
                    left=i;
                    i=m;
                    while(i<nums.length-1 && nums[i]==nums[i+1]) i++;
                    right=i;
                    return new int[]{left,right};
                
            }else if(nums[m]<target){
                l=m+1;
            }else{
                h=m-1;
            }
        }
        return new int[]{left,right};
    }
}