class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;


        int max = 0;
        boolean visited[][] =new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                    if(grid[i][j]==1 && !visited[i][j]){
                        int area = dfs(i,j,grid,visited);
                        max = Math.max(max,area);
                    }

            }
        }

        return max;
    }


    public int dfs(int row, int col, int[][] grid, boolean[][] visited){

        int n = grid.length;
        int m = grid[0].length;

        if(row<0 || row>=n || col<0 || col>=m || visited[row][col]==true || grid[row][col]==0){
            return 0;
        }

        visited[row][col] = true;

        int val = 1;

        val+=dfs(row+1,col,grid,visited);
        val+=dfs(row-1,col,grid,visited);
       val+= dfs(row,col+1,grid,visited);
       val+= dfs(row,col-1,grid,visited);

        return val;

    }
}