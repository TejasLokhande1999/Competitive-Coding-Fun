class Solution {
    int dp[];
    public int climbStairs(int n) {
        dp = new int[n];
        Arrays.fill(dp,-1);
       return dfs(0,n);
    }


    public int dfs(int i, int n){

        if(i>n){
            return 0;
        }
        if(i==n){
            return 1;
        }

        if(dp[i]!=-1){
            return dp[i];
        }
        return dp[i] = dfs(i+1,n)+dfs(i+2,n);
    }
}