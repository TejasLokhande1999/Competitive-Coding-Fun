class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        dfs(0,0,m,n,grid,dp);

        return dp[0][0];
    }

    public int dfs(int i, int j, int rows, int cols, int[][] mat, int[][] dp){

        if(i>=rows) return Integer.MAX_VALUE;

        if(j>=cols) return Integer.MAX_VALUE;

        if(i==rows-1 && j==cols-1){
            dp[i][j] = mat[i][j];
            return dp[i][j];
        }

        if(dp[i][j]!=-1)
            return dp[i][j];

        
        dp[i][j] = mat[i][j] + Math.min(dfs(i+1,j,rows,cols,mat,dp), dfs(i,j+1,rows,cols,mat,dp));

        return dp[i][j];

    }
}