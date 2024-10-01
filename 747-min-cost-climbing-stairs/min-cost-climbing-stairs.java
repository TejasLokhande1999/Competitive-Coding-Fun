class Solution {
    public int minCostClimbingStairs(int[] cost) {
     int n = cost.length;

     n = n+1;

     int dp[] = new int [n];

        for(int i=0;i<cost.length;i++){
            dp[i] = cost[i];
        }
        dp[n-1] =0;


     for(int i=n-3;i>=0;i--){
        dp[i] = dp[i] + Math.min(dp[i+1],dp[i+2]);
     }

     return Math.min(dp[0],dp[1]);


     
    }
}