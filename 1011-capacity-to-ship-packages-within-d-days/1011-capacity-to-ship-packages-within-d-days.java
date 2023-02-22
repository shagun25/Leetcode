class Solution {
    boolean check(int[] weights, int mid, int days){
        int count=0;
        int W=0;
        for(int weight : weights){
            W+=weight;
            if(W>mid){
                W=weight;
                count++;
            }
        }
        return count>=days?false:true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum=0, max = Integer.MIN_VALUE;
        for(int weight : weights){
            sum+=weight;
            max = Math.max(max,weight);
        }
        int low = max, high = sum,ans=0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(check(weights,mid,days)) {
                high=mid-1;ans=mid;
            }
            else low=mid+1;
        }
        return ans;
    }
}