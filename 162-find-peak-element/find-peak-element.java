class Solution {
    public int findPeakElement(int[] arr) {
        
        if(arr.length==1){
            return 0;
        }

        if(arr[0]>arr[1]){
            return 0;
        }

        int n = arr.length;

        if(arr[n-1]>arr[n-2]){
            return n-1;
        }

        // for(int i=1;i<n-1;i++){
        //     if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
        //         return i;
        //     }
        // }

        // return -1;

        int start =1;
        int end =n-2;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }else if(arr[mid-1]< arr[mid] && arr[mid]<arr[mid+1]){
                //peak element at right

                start = mid+1;
            }else{
                end = mid-1;
            }

        }


    return -1;

    }
}