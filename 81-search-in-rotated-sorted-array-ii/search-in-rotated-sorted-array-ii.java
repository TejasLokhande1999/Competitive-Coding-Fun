class Solution {
    public boolean search(int[] arr, int target) {
        
 int start = 0;
        int end = arr.length-1;


        while(start<=end){

            int mid = start + (end - start)/2;

            if(arr[mid]==target){
                return true;
            }else if(arr[start] == arr[mid] && arr[mid]==arr[end]){
                //reduce the search space
                start = start+1;
                end = end-1;

            }else if(arr[start]<=arr[mid]){     //left portion sorted

                if(arr[start]<=target && target<=arr[mid]){ //target lies here
                    end = mid-1;
                }else{
                    start = mid+1;
                }

            }else{      //right portion sorted

            if(arr[mid]<=target && target<=arr[end]){ //target lies here
                    start = mid+1;
                }else{
                    end = mid-1;
                }

            }

        }

        return false;


    }
}