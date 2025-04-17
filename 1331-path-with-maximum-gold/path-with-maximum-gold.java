class Solution {

    int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int getMaximumGold(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int res =0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(grid[i][j]>0){

                    int ans = dfs(i,j,grid, new boolean[rows][cols]);
                    res = Math.max(res,ans);
                }

            }
        }

        return res;

    }

    public int dfs(int i, int j, int grid[][], boolean visited[][]){

        int m = grid.length;
        int n = grid[0].length;

        if(i<0 || j<0 || i>=m || j>=n || visited[i][j] || grid[i][j]==0)
            return 0;

        visited[i][j]= true;

        int res = grid[i][j];

        for(int d[] : dir){
            res = Math.max(res, grid[i][j] + dfs(i+d[0],j+d[1],grid,visited));
        }

        visited[i][j] = false;

        return res;



    }
}