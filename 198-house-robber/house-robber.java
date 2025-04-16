class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);

        int ans = dfs(0,n,nums,dp);

        return ans;

    }

    public int dfs(int index, int n, int nums[], int dp[]){

        if(index>=n) return 0;

        if(index==n-1) return nums[n-1];

        if(dp[index]!=-1) return dp[index];

        return dp[index] = Math.max(nums[index]+dfs(index+2,n,nums,dp),dfs(index+1,n,nums,dp));

    }


}