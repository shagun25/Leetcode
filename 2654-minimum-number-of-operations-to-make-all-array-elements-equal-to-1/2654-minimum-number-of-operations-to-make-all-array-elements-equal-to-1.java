class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count=0;
        for(int x: nums) if(x==1) count++;
        if(count>0) return n-count;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int g=nums[i];
            for(int j=i+1;j<n;j++){
                g=gcd(g,nums[j]);
                if(g==1) ans=Math.min(ans,j-i+n-1);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    int gcd(int a,int b){
        if(a==0) return b;
        return gcd(b%a,a);
    }
}