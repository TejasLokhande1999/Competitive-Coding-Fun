class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0,j=0;
        int n = nums.length;
        while(j<n){
            if(nums[i]==nums[j])
                j++;
            else{
                i = i+1;
                nums[i] = nums[j];
                j++;
            }
        }

        return i+1;
    }
}