class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length,m=matrix[0].length;
        long maxSum=0;
        int minNegVal=Integer.MAX_VALUE,negCount=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maxSum+=Math.abs(matrix[i][j]);
                if(matrix[i][j]<0) negCount++;
                minNegVal=Math.min(minNegVal,Math.abs(matrix[i][j]));
            }
        }
        if(negCount%2!=0) maxSum=maxSum-2*minNegVal;
        return maxSum;
    }
}