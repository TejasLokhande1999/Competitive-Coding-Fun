class Solution {
    public int maxSubArray(int[] nums) {
        
        // int maxSum=Integer.MIN_VALUE;

        // for(int i=0;i<nums.length;i++){

        //     int sum=0;
        //     for(int j=i;j<nums.length;j++){
        //         sum+=nums[j];
        //         maxSum = Math.max(maxSum,sum);
        //     }
        // }

        // if(nums.length==1){
        //     return nums[0];
        // }
        // return maxSum;

        if(nums.length==1){
            return nums[0];
        }

        int maxSum=Integer.MIN_VALUE;
        int currSum=0;

        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            if(currSum>maxSum){
                maxSum = currSum;
            }
            if(currSum<0){      //Set it to 0 as it makes no sense to carry a -ve number forward. It will reduce the overall value
                currSum=0;
            }
        }

    return maxSum;

    }
}