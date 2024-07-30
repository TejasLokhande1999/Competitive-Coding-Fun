class Solution {
    public boolean searchMatrix(int[][] matrix, int ele) {

       int n = matrix.length;
       int m = matrix[0].length;

       int start = 0;
       int end = n*m -1;

       while(start<=end){
        int mid = start+(end-start)/2;

        int row = mid/m;
        int col = mid%m;

        if(matrix[row][col]==ele){
            return true;
        }else if(matrix[row][col]<ele){
            start = mid+1;
        }else{
            end = mid-1;
        }

       } 

       return false;
       

    }

    
}