class Solution {
    public void setZeroes(int[][] matrix) {
        
        boolean rows[] = new boolean[matrix.length];        //default fasle

        boolean cols[] = new boolean[matrix[0].length]; //default fasle


        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0){
                    rows[i]=true;
                    cols[j]=true;
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){

                if(rows[i]==true || cols[j]==true){
                    matrix[i][j]=0;
                }

            }
        }


    }
}