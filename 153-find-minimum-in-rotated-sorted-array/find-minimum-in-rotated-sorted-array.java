class Solution {
    public int findMin(int[] arr) {
        
        int start =0;
        int end = arr.length-1;
        int n = arr.length;

        // //base condition
        // if(nums[start]<nums[end]){
        //     return nums[start];
        // }

        // while(start<=end){

        //     int mid = start + (end-start)/2;

        //     if(nums[start]<nums[end]){
        //     return nums[start];
        // }
        //     if(nums[(mid+1)%n]>= nums[mid] && nums[mid]<=nums[(mid + n-1)%n]){
        //         return nums[mid];
        //     }
        //     else if(nums[start]<=nums[mid]){
        //         //mode right as we are in sorted array
        //         start = mid+1;
        //     }else if(nums[mid]<=nums[end]){
        //         end = mid-1;
        //     }

        // }

        // return 0;


        int min = Integer.MAX_VALUE;
        if(arr[0]<=arr[n-1]){
            return arr[0];
        }else{

            while(start<=end){

                int mid = start + (end-start)/2;

                if(arr[start]<=arr[mid]){
                    min = Math.min(min,arr[start]);
                    //go to unsorted portion
                    start = mid+1;
                }else{
                    min = Math.min(min,arr[mid]);
                    end = mid-1;
                }
            }




        }



            return min;


    }
}