class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int dp1[] = new int[n];
        int dp2[] = new int[n];

        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.max(knap(nums,dp1,0,n-2), knap(nums,dp2,1,n-1));
    }

    int knap(int nums[], int dp[], int start, int n){

        if(n<start){
            return 0;
        }else if(dp[n]!=-1){
            return dp[n];
        }else{

            return dp[n] = Math.max(nums[n]+knap(nums,dp,start,n-2), knap(nums,dp,start,n-1));
        }

    }
}