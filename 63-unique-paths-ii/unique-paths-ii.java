class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        int val = dfs(0,0,grid,dp);
        return val;
    }

    public int dfs(int i, int j, int grid[][], int dp[][]){
        
        int m = grid.length;
        int n = grid[0].length;
        if(i>=m || j>=n || grid[i][j]==1)
            return 0;
        if(i==m-1 && j==n-1)
            return 1;

        //else

        if(dp[i][j]!=-1)
            return dp[i][j];

        dp[i][j] = dfs(i+1,j,grid,dp) + dfs(i,j+1,grid,dp);
        return dp[i][j];
    }
}