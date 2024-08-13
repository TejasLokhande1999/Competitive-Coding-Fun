class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0;i<m;i++){

            boolean val = binSearch(matrix[i],0,n-1,target);
            if(val==true){
                return true;
            }

        }

        return false;

    }


    public boolean binSearch(int arr[], int start, int end, int ele){

        while(start<=end){
            int mid = start+(end-start)/2;

            if(arr[mid]==ele){
                return true;
            }else if(arr[mid]<ele){
                start = mid+1;
            }else{
                end = mid-1;
            }

        }

        return false;
    }


}