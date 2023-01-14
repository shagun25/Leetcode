class Solution {
    public void rotate(int[][] matrix) {
        // Approach:
        // 1. transpose-> row->col, col->row
        // 2. reverse rows
        int n = matrix.length,m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                swap(matrix,i,j);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m/2;j++) reverse(matrix,i,j);
        }
    }
    void swap(int[][] matrix,int i,int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    void reverse(int matrix[][],int i,int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][matrix.length - 1 - j];
        matrix[i][matrix.length - 1 - j] = temp;
    }
}