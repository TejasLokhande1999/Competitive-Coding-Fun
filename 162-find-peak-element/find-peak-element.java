class Solution {
    public int findPeakElement(int[] nums) {
        
    int newArr[] = new int[nums.length+2];

    newArr[0] = Integer.MIN_VALUE;
    newArr[newArr.length-1] = Integer.MIN_VALUE;
    for(int i=1;i<newArr.length-1;i++)
    {
        newArr[i] = nums[i-1];
    }
    for(int i=1;i<newArr.length-1;i++)
        {
            if(newArr[i]>newArr[i-1]&&newArr[i]>newArr[i+1])
            {
                return i-1;             //because of 0 based indexing
            }
        }

        return 0;
    }
}