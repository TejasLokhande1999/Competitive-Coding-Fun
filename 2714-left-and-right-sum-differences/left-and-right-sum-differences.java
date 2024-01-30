class Solution {
    public int[] leftRightDifference(int[] nums) {
        int currentSumLeft=0;
        int currentSumRight =0;

        int leftSum[] = new int[nums.length];
        int rightSum[] = new int[nums.length];
     

        for(int i=0;i<nums.length;i++)
        {
            if(i==0)
            {
                leftSum[i]=0;
                currentSumLeft+=nums[i];
            }else{
                leftSum[i] = currentSumLeft;
                currentSumLeft+=nums[i];

            }
        }

        for(int i=nums.length-1;i>=0;i--)
        {
            if(i==nums.length-1)
            {
                rightSum[i]=0;
                currentSumRight+=nums[i];
            }else{
                rightSum[i] = currentSumRight;
                currentSumRight+=nums[i];

            }
        }

        int leftRightDifference[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            leftRightDifference[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return leftRightDifference;

    }
}