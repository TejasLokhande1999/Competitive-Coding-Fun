class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        int j=0;
        int n = nums.length;

        while(i<n && nums[i]!=0){
            i++;
        }
        if(j<n)
            j=i+1;

        while(j<n && i<n){
            if(nums[j]!=0){
                int temp = nums[j];
                nums[j]=nums[i];
                nums[i] = temp;
                i++;
                j++;
            }else{
                j++;
            }
        }
    }
}