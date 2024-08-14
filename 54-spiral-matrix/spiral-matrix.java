class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        ArrayList<Integer> list = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int left =0;
        int bottom = rows-1;
        int right = cols-1;


        while(top<=bottom && left<=right){

            //ttrace ffrom left to right
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            top++;

            //trace from top to bottom
            for(int i=top; i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            right--;

            //trace from right to left

            if(top<=bottom){
             for(int i=right;i>=left;i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }


            //trace from bottom to top

            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }


        }

        return list;


    }
}