class Solution {
    public String convert(String s, int numRows) {
        char grid[][] = new char[numRows][s.length()];

        
        if(s.length()==1){
            return s;
        }
        if(numRows==1){
            return s;
        }
        for(char row[] : grid){
            Arrays.fill(row, ' ');
        }


        boolean goingDown = true;
        int row = 0;
        int col=0;

        for(char ch : s.toCharArray()){

            if(goingDown){
                grid[row][col]=ch;

                if(row==numRows-1){
                    goingDown = false;  //we go up
                    row--;
                    col++;  //going in the 1st quadrant
                }else{
                    row++;
                }

            }else{
                //we are going up
                grid[row][col] = ch;
                if(row==0){
                    goingDown = true;
                    row++;
                }else{

                    row--;
                    col++;
                }

            }

        }


        StringBuilder retStr = new StringBuilder();

        for(char currRow[] : grid){

            for(char ch : currRow){
                if(ch!=' '){
                    retStr.append(ch);
                }
        }

        }

        return retStr.toString();
    }
}