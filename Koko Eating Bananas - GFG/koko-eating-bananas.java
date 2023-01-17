//{ Driver Code Starts
import java.util.*;
import java.lang.*;
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
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    static long checkHours(int N, int[] piles,int mid){
         long hours=0;
        for(int i=0;i<N;i++)
            {
                hours+=piles[i]/mid;
				
                if(piles[i]%mid!=0)hours++;
            }
            return hours;
    }
    public static int Solve(int N, int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        for(int pile: piles)
            max=Math.max(pile,max);
        
        int low=1,high=max;
        while(low<high)
        {
            int mid=(low+high)/2;
            if(checkHours(N,piles,mid)<=h)high=mid;
            else low=mid+1;
        }
        return low;
    }
}
        
