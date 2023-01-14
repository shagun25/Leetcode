class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix.length==0) return list;
        int n=matrix.length;
        int top=0,right=matrix[0].length-1,bottom=matrix.length-1,left=0;
        int dir=0;
        while(top<=bottom && left<=right){
            if(dir==0){
            for(int j=left;j<=right;j++)
               list.add(matrix[top][j]);
            top++;
            }
            else if(dir==1){
           for(int i=top;i<=bottom;i++)
               list.add(matrix[i][right]);
           right--;
            }
            else if(dir==2){
              for(int j=right;j>=left;j--)
                 list.add(matrix[bottom][j]);
              bottom--;
            }
            else if(dir==3){
              for(int i=bottom;i>=top;i--)
                 list.add(matrix[i][left]);
              left++; 
           }
           dir=(dir+1)%4;
        }
        return list;
    }
}