class Solution {
    public void rotate(int[][] matrix) {
        

        //first calculate the transpose

        int n = matrix.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(j<i){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i]=temp;
                }

            }
        }

        for(int i=0;i<n;i++){
            reverse(i,matrix);
        }



    }

    public void reverse(int row, int[][] matrix){

        int start=0;
        int end = matrix.length-1;

        while(start<end){

            int temp = matrix[row][start];
            matrix[row][start] = matrix[row][end];
            matrix[row][end] = temp;
            start++;
            end--;
        }
    }

}