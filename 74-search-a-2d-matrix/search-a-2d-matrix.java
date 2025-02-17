class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows*cols-1;

        while(left<=right){
            
            int mid = left+(right-left)/2;
            int n = mid/cols;
            int m = mid%cols;

            if(matrix[n][m]==target){
                return true;
            }else if(matrix[n][m]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }

        }

        return false;
    }
}




// n*m = 12
// 0 1 2 3 4 5 6 7 8 9 10 11 
