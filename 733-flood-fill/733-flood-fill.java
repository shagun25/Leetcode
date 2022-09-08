class Solution {
    void dfs(int[][] image, int i, int j,int imgColor, int color){
        if(i<0 || i>=image.length || j<0 || j>=image[i].length || image[i][j]!=imgColor) return;
        image[i][j]=color;
        dfs(image,i+1,j,imgColor,color);
        dfs(image,i-1,j,imgColor,color);
        dfs(image,i,j+1,imgColor,color);
        dfs(image,i,j-1,imgColor,color);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        dfs(image,sr,sc,image[sr][sc],color);
        // for(int i=0;i<image.length;i++){
        //     for(int j=0;j<image[i].length;j++){
        //         if(image[i][j]==-1){
        //             image[i][j]=color;
        //         }
        //     }
        // }
        return image;
    }
}