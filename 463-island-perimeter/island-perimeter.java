class Solution {
    public int islandPerimeter(int[][] grid) {
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return dfs(i,j,grid);
                }
            }
        }

        return 0;

    }

    public int dfs(int i, int j, int grid[][]){

        int rows = grid.length;
        int cols = grid[0].length;

        if(i<0 || i>=rows || j<0 || j>=cols || grid[i][j]==0){
            return 1;
        }

        //check if visited. If visited, then rerurn 0
        if(grid[i][j]==-1){
            return 0;
        }

        //marked as visited
        grid[i][j]=-1;

        int p=0;
        p+=dfs(i+1,j,grid);
        p+=dfs(i-1,j,grid);
        p+=dfs(i,j+1,grid);
        p+=dfs(i,j-1,grid);

        return p;
    }
}