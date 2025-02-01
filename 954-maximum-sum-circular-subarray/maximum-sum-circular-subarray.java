class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //use Kadane's also and calculate globalMax

        int globalMax = Integer.MIN_VALUE;
        int currSum = 0;
        int n = nums.length;
        int total=0;
        for(int i=0;i<n;i++){
            currSum += nums[i];
            total+=nums[i];
            globalMax = Math.max(globalMax,currSum);

            if(currSum<0){
                currSum = 0;
            }
        }

        int globalMin = Integer.MAX_VALUE;
        int currSum2 = 0;

        for(int i=0;i<n;i++){
            currSum2+=nums[i];

            if(globalMin>currSum2){
                globalMin = currSum2;
            }
            if(currSum2>0){
                currSum2 = 0;
            }
        }


        int s2 = total - globalMin;
        if(globalMax<0){
            return globalMax;
        }
        return Math.max(globalMax, s2);

    }
}