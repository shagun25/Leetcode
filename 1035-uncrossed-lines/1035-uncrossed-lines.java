class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int memo[][] = new int[n1+1][n2+1];
        for(int mem[] : memo)
            Arrays.fill(mem,-1);
        return recursion(nums1,nums2,n1,n2,memo);
    }
    int recursion(int[] nums1,int[] nums2,int i,int j,int memo[][]){
        if(i<=0 || j<=0) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        if(nums1[i-1]==nums2[j-1])  memo[i][j]=1+recursion(nums1,nums2,i-1,j-1,memo);
        else memo[i][j]=Math.max(recursion(nums1,nums2,i-1,j,memo),recursion(nums1,nums2,i,j-1,memo));
        return memo[i][j];
    }
}