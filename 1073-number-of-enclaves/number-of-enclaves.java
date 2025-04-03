class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean visited[][] = new boolean[rows][cols];


        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(grid[i][j] ==1 && !visited[i][j] && (i==0 || i==rows-1 || j==0 || j==cols-1)){
                    dfs(i,j,grid,visited);
                }
            }
        }

        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(grid[i][j] ==1 && !visited[i][j]){
                    count+=1;
                }
            }
        }

        return count;

        
    }

    public void dfs(int i, int j, int[][] grid, boolean visited[][]){

        int m = grid.length;
        int n = grid[0].length;


        if(i>=m || i<0 || j>=n || j<0 || visited[i][j] || grid[i][j]==0){
            return;
        }
        //else grid[i][j] = 1;

        visited[i][j] = true;

        dfs(i-1,j,grid,visited);
        dfs(i+1,j,grid,visited);
        dfs(i,j+1,grid,visited);
        dfs(i,j-1,grid,visited);

    }
}