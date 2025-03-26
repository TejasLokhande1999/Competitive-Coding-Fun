class Solution {
    int dp[][];
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(s,t,0,0,m,n);
    }


    public int dfs(String s, String t, int i, int j, int m, int n){

        if(j==n){
            return 1;
        }

        if(i==m){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==t.charAt(j)){

            return dp[i][j] = dfs(s,t,i+1,j+1,m,n)+dfs(s,t,i+1,j,m,n);

        }else{
            return dp[i][j] = dfs(s,t,i+1,j,m,n);
        }


    }
}