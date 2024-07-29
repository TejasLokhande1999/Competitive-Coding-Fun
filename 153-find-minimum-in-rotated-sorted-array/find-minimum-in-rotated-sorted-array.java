class Solution {
    public int findMin(int[] nums) {
        
        int start =0;
        int end = nums.length-1;
        int n = nums.length;

        //base condition
        if(nums[start]<nums[end]){
            return nums[start];
        }

        while(start<=end){

            int mid = start + (end-start)/2;

            if(nums[start]<nums[end]){
            return nums[start];
        }
            if(nums[(mid+1)%n]>= nums[mid] && nums[mid]<=nums[(mid + n-1)%n]){
                return nums[mid];
            }
            else if(nums[start]<=nums[mid]){
                //mode right as we are in sorted array
                start = mid+1;
            }else if(nums[mid]<=nums[end]){
                end = mid-1;
            }

        }

        return 0;


    }
}