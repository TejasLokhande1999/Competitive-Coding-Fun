class Solution {
    int dp[];
    public int coinChange(int[] coins, int amount) {
        
        dp = new int[amount+1];
        Arrays.fill(dp,-1);
        int minCoins =  dfs(coins,amount);

        if(minCoins==Integer.MAX_VALUE){
            return -1;
        }

        return minCoins;
    }

    public int dfs(int coins[], int amount){


        if(amount==0){
            return 0;
        }

        if(amount<0){
            return Integer.MAX_VALUE;
        }

        if(dp[amount]!=-1){
            return dp[amount];
        }

        int minCoins = Integer.MAX_VALUE;

        for(int coin : coins){
            int res = dfs(coins,amount-coin);
            if(res!=Integer.MAX_VALUE){
                minCoins = Math.min(minCoins,1+res);
            } 
        }

        return dp[amount] = minCoins;

    }
}