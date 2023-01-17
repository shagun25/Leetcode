class Solution {
    long checkHours(int N, int[] piles,int mid){
         long hours=0;
        for(int i=0;i<N;i++)
            {
                hours+=piles[i]/mid;
				
                if(piles[i]%mid!=0)hours++;
            }
            return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int N = piles.length;
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