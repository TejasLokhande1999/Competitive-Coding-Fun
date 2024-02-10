class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length==1 || k==0)
        {
            return;
        }
        if(k>nums.length)
        {
            k=k%nums.length;
        }
        nums = reverseArr(nums, 0,nums.length-1);
        nums = reverseArr(nums,0,k-1);
        nums = reverseArr(nums,k,nums.length-1);
    }

    public int[] reverseArr(int[] nums, int left, int right)
    {
        
        int temp;
        int mid = (left+right)/2;
        while(left<=mid)
        {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

        return nums;
    }
}