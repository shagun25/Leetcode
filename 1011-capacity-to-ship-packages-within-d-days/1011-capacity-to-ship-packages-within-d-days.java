class Solution {
    int check(int[] weights, int mid){
        int sum=0;
        int count=0;
     for(int weight: weights){
         sum+=weight;
         if(sum>mid) {sum=weight;count++;}
     }
        return count;
    }
    public int shipWithinDays(int[] weights, int days) {
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
}