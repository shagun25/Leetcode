class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int dp[] = new int[n];
        Arrays.sort(envelopes, (a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int omax=0;
        for(int i=0;i<n;i++){
            int index = bs(dp,0,omax,envelopes[i][1]);
            dp[index]=envelopes[i][1];
            if(index==omax) omax++;
        }
        return omax;
    }
    int bs(int dp[], int s, int e, int target){
        int index = Arrays.binarySearch(dp,s,e,target);
        if(index<0) index = - (index+1);
        return index;
    }
}