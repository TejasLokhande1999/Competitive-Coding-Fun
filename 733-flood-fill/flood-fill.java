class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image[sr][sc]==color){
            return image;
        }

        int m = image.length;
        int n = image[0].length;

        boolean visited[][] = new boolean[m][n];
        int oldColor = image[sr][sc];
        dfs(image,sr,sc,color,oldColor,visited);

        return image;

    }

    public void dfs(int[][] grid, int i, int j, int newColor,int oldColor, boolean[][] visited){

        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || grid[i][j]!=oldColor){
            return;
        }

        visited[i][j]=true;
        grid[i][j]= newColor;

        dfs(grid,i+1,j,newColor,oldColor,visited);
        dfs(grid,i-1,j,newColor,oldColor,visited);
        dfs(grid,i,j+1,newColor,oldColor,visited);
        dfs(grid,i,j-1,newColor,oldColor,visited);




    }
}