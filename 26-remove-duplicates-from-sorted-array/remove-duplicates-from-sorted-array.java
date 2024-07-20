class Solution {
    public int removeDuplicates(int[] nums) {
        
        
        int i=0;

        int n = nums.length;

        for(int j=1;j<n;j++){
            if(nums[i]!=nums[j]){           //put arr[j] in arr[i+1]
                nums[i+1]=nums[j];
                i+=1;
            }
        }


    return i+1;

    }
}