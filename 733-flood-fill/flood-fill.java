class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int oldColor= image[sr][sc];

        if(oldColor==newColor){
            return image;
        }else{
            dfs(sr,sc,image,oldColor,newColor);
        }

        return image;
    }

    public void dfs(int row, int col, int[][] grid, int oldColor, int newColor){

        int m = grid.length;
        int n = grid[0].length;

        if(row<0 || row>=m || col<0 || col>=n || grid[row][col]!=oldColor){
            return;
        }

        grid[row][col]=newColor;

        dfs(row+1,col,grid,oldColor,newColor);
        dfs(row-1,col,grid,oldColor,newColor);
        dfs(row,col+1,grid,oldColor,newColor);
        dfs(row,col-1,grid,oldColor,newColor);




    }
}