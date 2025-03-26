class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        HashSet<String> set = new HashSet<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(board[i][j]!='.')
                {

                    String row = "ROW" + i + board[i][j];
                    String col = "COL" + j + board[i][j];
                    String box = "BOX"+(i/3)+(j/3)+board[i][j];

                    if(!set.contains(row) && !set.contains(col) && !set.contains(box)){
                        set.add(row);
                        set.add(col);
                        set.add(box);
                        continue;
                    }else{
                        return false;
                    }

                }
            
            }


        }

        return true;
    }
}