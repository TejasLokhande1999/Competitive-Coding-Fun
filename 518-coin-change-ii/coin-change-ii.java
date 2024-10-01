class Solution {
    public int change(int amount, int[] coins) {
        
        int n = coins.length;
        int S = amount;

        int t[][] = new int[n+1][S+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<S+1;j++){
                t[i][j]=-1;
            }
        }

        return knap(coins,n,S,t);

    }

    public int knap(int coins[], int n, int S, int t[][]){

        if(S==0){
            return 1;   //we found 1 way
        }
        if(S<0 || n==0){
            return 0;      //No way found
        }
        if(t[n][S]!=-1){
            return t[n][S];
        }
        if(coins[n-1]<=S){
            //take it andd not not take it

            return t[n][S] = knap(coins,n,S-coins[n-1],t) + knap(coins,n-1,S,t);

        }else{

            return t[n][S]= knap(coins,n-1,S,t);
        }

    }
}