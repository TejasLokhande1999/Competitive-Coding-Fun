class Solution {
    public int uniquePaths(int m, int n) {

     int dp[][] = new int[m][n];
     for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            dp[i][j] = -1;
        }
     }

     return dfs(0,0,m,n,dp);

    }

    public int dfs(int i, int j, int rows, int cols, int dp[][]){
        if(i>=rows) return 0;
        if(j>=cols) return 0;

        if(i==rows-1 && j==cols-1)
            return 1;

        if(dp[i][j]!=-1)
            return dp[i][j];

        dp[i][j] = dfs(i+1,j,rows,cols,dp) + dfs(i,j+1,rows,cols,dp);

        return dp[i][j];

    }
}