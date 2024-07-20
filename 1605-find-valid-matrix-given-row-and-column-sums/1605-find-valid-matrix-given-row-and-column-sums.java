class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int N = rowSum.length;
        int M = colSum.length;
       int ans[][]= new int[N][M];
        int cnt=N*M;

        while(cnt-->0){
            int row=-1; int col=-1;
            int minRowVal=Integer.MAX_VALUE, minColVal=Integer.MAX_VALUE;
            for(int i=0;i<N;i++){
                if(rowSum[i]<minRowVal && rowSum[i]>0){
                    row=i; 
                    minRowVal=rowSum[i];
                }
            }
            for(int j=0;j<M;j++){
                if(colSum[j]<minColVal && colSum[j]>0){
                    col=j; 
                    minColVal=colSum[j];
                }
            }
            if(minRowVal==Integer.MAX_VALUE && minColVal==Integer.MAX_VALUE){
                return ans;
            }
            int val=Math.min(minRowVal,minColVal);
            rowSum[row]-=val;
            colSum[col]-=val;
            ans[row][col]=val;
        }
        return ans;
    }
}