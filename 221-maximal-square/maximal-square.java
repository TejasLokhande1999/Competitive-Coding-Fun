class Solution {

    int dp[][];
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        dp = new int[rows][cols];

        for(int i=0;i<rows;i++){
            Arrays.fill(dp[i],-1);
        }

        dfs(0,0,rows,cols,matrix);

        int maxVal = -1;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                maxVal = Math.max(maxVal,dp[i][j]);
            }
        }

        return maxVal*maxVal;
    
    }

    public int dfs(int i, int j, int rows, int cols, char[][] matrix){

        if(i>=rows || j>=cols){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int right = dfs(i,j+1,rows,cols,matrix);
        int down = dfs(i+1,j,rows,cols,matrix);
        int diag = dfs(i+1,j+1,rows,cols,matrix);

        
        dp[i][j] = 0;
        if(matrix[i][j]=='1'){
            dp[i][j] = 1 + Math.min(right, Math.min(down,diag));
        }

        return dp[i][j];

    }
}