class Solution {
    int checkDays(int N, int[] bloomDay,long mid,int m,int k){
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
    public int minDays(int[] bloomDay, int m, int k) {
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