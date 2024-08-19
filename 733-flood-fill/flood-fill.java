class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        if(initialColor!=color)
            dfs(image,sr,sc,color,initialColor);
        return image;
    }

    public void dfs(int image[][], int i, int j, int color, int initialColor){

    //base condition
    int row = image.length;
    int col = image[0].length;

    if(i<0 || i>=row || j<0 || j>=col || image[i][j]!=initialColor){
        return;
    }

    image[i][j]=color;

    dfs(image,i+1,j,color,initialColor);
    dfs(image,i-1,j,color,initialColor);
    dfs(image,i,j+1,color,initialColor);
    dfs(image,i,j-1,color,initialColor);

    }


}