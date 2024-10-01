class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];

        Arrays.fill(dp,-1);

        int result = dfs(coins,amount,dp);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int dfs(int coins[], int amount, int dp[]){

        if(amount==0){
            return 0;
        }
        if(amount<0){
            return Integer.MAX_VALUE;
        }
        if(dp[amount]!=-1){
            return dp[amount];      //how many min coins are needed for this amount
        }

        int minCoins =Integer.MAX_VALUE;

        for(Integer coin : coins){

            int ans = dfs(coins, amount-coin,dp);

            if(ans!=Integer.MAX_VALUE)
                minCoins = Math.min(minCoins,ans+1);
        }

        dp[amount] = minCoins;

        return minCoins;

    }
}