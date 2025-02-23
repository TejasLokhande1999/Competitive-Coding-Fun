class Solution {
    public int maxAreaOfIsland(int[][] grid) {

     int m = grid.length;
     int n = grid[0].length;

     boolean visited[][] = new boolean[m][n];

    int maxCount = 0;


    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(!visited[i][j] && grid[i][j]==1){
                int count = dfs(i,j,grid,visited);
                maxCount = Math.max(maxCount,count);
                count=1;
            }
        }
    }

    return maxCount;

    }

    public int dfs(int i, int j, int grid[][], boolean visited[][]){

        int rows = grid.length;
        int cols = grid[0].length;

        if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j] || grid[i][j]==0){
            return 0;
        }

       int count=1;
        visited[i][j] = true;


        count+=dfs(i-1,j,grid,visited);
        count+=dfs(i+1,j,grid,visited);
        count+=dfs(i,j-1,grid,visited);
        count+=dfs(i,j+1,grid,visited);

        
        return count;
    }
}