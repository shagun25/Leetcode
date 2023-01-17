class Solution {
    int check(int[] nums, int mid){
        int sum=0;
        for(int num: nums){
            sum+=(int)Math.ceil((double)num/mid);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        
        int max=Integer.MIN_VALUE;
        for(int num: nums){
            max=Math.max(num,max);
        }
    
        int low=1,high=max;
        while(low<high)
        {
            int mid=low+(high-low)/2;
            if(check(nums,mid)<=threshold) high=mid;
            else low=mid+1;
        }
        return low;
    }
}