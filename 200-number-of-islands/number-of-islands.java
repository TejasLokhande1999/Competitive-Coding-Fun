class Solution {
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        boolean visited[][]= new boolean[rows][cols];
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                
                if(!visited[i][j] && grid[i][j]=='1'){
                    count+=1;
                    dfs(i,j,grid,visited);
                }

            }
        }

        return count;


    }


    public void dfs(int row, int col, char[][] grid, boolean visited[][]){
        int n = grid.length;
        int m = grid[0].length;
        if(row>=n || row<0 || col>=m || col<0 || visited[row][col] || grid[row][col]=='0'){
            return;
        }

        visited[row][col] = true;

        dfs(row-1,col,grid,visited);
        dfs(row+1,col,grid,visited);
        dfs(row,col-1,grid,visited);
        dfs(row,col+1,grid,visited);

    }
}