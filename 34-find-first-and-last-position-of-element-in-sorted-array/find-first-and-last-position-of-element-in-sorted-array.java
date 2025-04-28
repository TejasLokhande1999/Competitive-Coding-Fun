class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = getLeftIndex(nums,target);

        int right=-1;

        if(left!=-1)
            right = getRightIndex(nums,target);
        
        return new int[] {left,right};
    }

    public int getLeftIndex(int nums[], int target){

        int start=0;
        int end = nums.length-1;
        int leftIndex=-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(nums[mid]==target){
                leftIndex=mid;
                end=mid-1;
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return leftIndex;

    }

    public int getRightIndex(int nums[], int target){

        int start=0;
        int end = nums.length-1;
        int rightIndex=-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(nums[mid]==target){
                rightIndex=mid;
                start = mid+1;
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return rightIndex;

    }


}