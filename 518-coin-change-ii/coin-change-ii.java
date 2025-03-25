class Solution {
    int t[][];
    public int change(int amount, int[] coins) {
        int n = coins.length;
        t = new int[n+1][amount+1];

        for(int i=0;i<n;i++){
            Arrays.fill(t[i],-1);
        }
        return dfs(0,n,coins,amount);
    }


    public int dfs(int i, int n, int coins[], int amount){
            if(i==n){
                return 0;
            }
            if(amount==0){
                return 1;
            }
            if(amount<0){
                return 0;
            }
            if(t[i][amount]!=-1){
                return t[i][amount];
            }

            if(coins[i]<=amount){
                return t[i][amount] = dfs(i,n,coins,amount-coins[i])+dfs(i+1,n,coins,amount);
            }else{

                return t[i][amount] = dfs(i+1,n,coins,amount);

            }

    }



}