class Solution {
    public int singleNonDuplicate(int[] arr) {
        

        int n = arr.length;

        if(arr.length==1){
            return arr[0];
        }else if(arr[0]!=arr[1]){
            return arr[0];
        }else if(arr[n-1]!=arr[n-2]){
            return arr[n-1];
        }

        int start=0;
        int end = n-1;

        while(start<=end){

            int mid = start + (end-start)/2;

            //check for the element
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]){
                return arr[mid];
            }

            if((mid%2==1 && arr[mid-1]==arr[mid]) || (mid%2==0 && arr[mid]==arr[mid+1])){
                //we are in left sub half, move to right
                start = mid+1;

            }else{
                end = mid-1;
            }

        }

        return 0;

    }
}