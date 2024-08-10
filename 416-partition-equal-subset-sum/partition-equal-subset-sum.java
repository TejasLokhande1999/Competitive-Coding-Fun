class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        if(sum%2==1){
            return false;
        }


    int S = sum/2;
    int n = nums.length;
    Boolean t[][] = new Boolean[n+1][S+1];
    return knapsack(nums,S,n,t);

    }

    public boolean knapsack(int arr[], int S, int n, Boolean t[][]){

        if(S==0){
            return true;
        }

        if(n==0){
            return false;
        }
        if(t[n][S]!=null){
            return t[n][S];
        }

        if(arr[n-1]<=S){
            return t[n][S] = knapsack(arr,S-arr[n-1],n-1,t) || knapsack(arr,S,n-1,t);
        }else if(arr[n-1]>S){
            //Don't take

            return t[n][S] = knapsack(arr,S,n-1,t);
        }

        return false;
    }

}

