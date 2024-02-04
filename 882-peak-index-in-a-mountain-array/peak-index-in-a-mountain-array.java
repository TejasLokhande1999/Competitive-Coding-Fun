class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int low = 0;
        int high = arr.length-1;

        return advBinarySearch(arr,low,high);

    }

    public int advBinarySearch(int arr[], int low, int high)
    {
        int mid = low + (high-low)/2;

        if(low<high){
            if(arr[mid]<arr[mid+1])
            {
                return advBinarySearch(arr,mid+1,high);
            }else if(arr[mid]>arr[mid+1])
            {
                return advBinarySearch(arr,low,mid);
            }
        }
        return low;

    }

    
}