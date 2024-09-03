class Solution {
    public int findMin(int[] arr) {
        int start=0;
        int end = arr.length-1;
        int n = arr.length;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(arr[start]<arr[end]){
                return arr[start];
            }
            if(arr[mid]<=arr[(mid-1+n)%n] && arr[mid]<=arr[(mid+1)%n]){
                return arr[mid];
            }else if(arr[mid]>=arr[start]){
                start = mid+1;   //go to unsorted portion
            }else{
                end = mid-1;
            }
        }

        return -1;

    }
}