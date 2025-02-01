class Solution {
    public int climbStairs(int n) {
        
        int cache[] = new int[n+1];

        for(int i=0;i<n+1;i++){
            cache[i] = -1;
        }


        int val = dfs(0,n,cache);

        return val;
    }

    public int dfs(int i,int n, int[] cache){

        if(i>n){
            return 0;
        }
        if(i==n){
            return 1;
        }

        if(cache[i]!=-1){
            return cache[i];
        }

        return cache[i] = dfs(i+1,n,cache) + dfs(i+2,n,cache);


    }


}