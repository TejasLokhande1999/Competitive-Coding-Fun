class Solution {
    public int search(int[] nums, int ele) {
        int start =0;
        int end = nums.length-1;

        while(start<=end){

            int mid = start + (end-start)/2;

            if(nums[mid]==ele)
                return mid;
            else if(nums[mid]<ele)
                start = mid+1;
            else
                end = mid-1;

        }


        return -1;
    }
}