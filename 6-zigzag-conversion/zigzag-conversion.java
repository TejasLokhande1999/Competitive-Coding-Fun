class Solution {
    public String convert(String s, int numRows) {
        int cols = s.length();
        int index =0;
        char grid[][] = new char [numRows][cols];
        int row = 0;
        int col=0;
        boolean isDown = true;

        if(numRows==1){
            return s;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                grid[i][j] = ' ';
            }
        }

        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);

            if(isDown){
                
                grid[row][col] = ch;
                if(row==numRows-1){
                    isDown = false;
                    col+=1;
                    row-=1;
                }else{
                    row+=1;
                }
            }else{
                
                grid[row][col] = ch;
                if(row==0){
                    isDown = true;
                    row+=1;
                }else{
                    col+=1;
                    row-=1;
                }
            }

        }

        String str = "";
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                char ch2 = grid[i][j];
                if(ch2!=' '){
                    str+=ch2;
                }
            }
        }

        return str;
    }
}