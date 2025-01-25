class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int j=0;
        int n = nums.length;
        int maxLength = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                j=i+1;
                while(j<n && nums[j]==1){
                    j++;
                }
                maxLength = Math.max(maxLength,j-i);
                i=j;
            }
        }

        if(maxLength==Integer.MIN_VALUE)
            return 0;
        return maxLength;
    }
}