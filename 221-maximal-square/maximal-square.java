class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int dp[][] = new int[m][n];


        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(dp[i][j]==-1 && matrix[i][j]=='1'){
                        dfs(i,j,matrix,dp);
                }

            }
        }

        int maxArea = 0;



    for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]>0){
                    int area = dp[i][j]*dp[i][j];
                    maxArea = Math.max(maxArea,area);
            }
            }
            System.out.println();
        }

    return maxArea;


    }

    public int dfs(int i, int j, char matrix[][], int dp[][]){
        
        int m = matrix.length;
        int n = matrix[0].length;
        if(i>=m || j>=n)
            return 0;

        if(matrix[i][j]=='0'){
            return 0;
        }


        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        dp[i][j]=0;

        dp[i][j] = 1+ Math.min(dfs(i+1,j,matrix,dp),Math.min(dfs(i+1,j+1,matrix,dp), dfs(i,j+1,matrix,dp)));

        return dp[i][j];


    }
}