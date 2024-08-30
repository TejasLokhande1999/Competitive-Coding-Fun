class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return dfs(i,j,grid,visited);
                }
            }
        }

        return 0;

    }

    public int dfs(int i, int j, int grid[][],boolean visited[][]){

        int rows = grid.length;
        int cols = grid[0].length;

        if(i<0 || i>=rows || j<0 || j>=cols || grid[i][j]==0){
            return 1;
        }

        //check if visited. If visited, then rerurn 0
        if(visited[i][j]){
            return 0;
        }

        //marked as visited
        visited[i][j]=true;

        int p=0;
        p+=dfs(i+1,j,grid,visited);
        p+=dfs(i-1,j,grid,visited);
        p+=dfs(i,j+1,grid,visited);
        p+=dfs(i,j-1,grid,visited);

        return p;
    }
}