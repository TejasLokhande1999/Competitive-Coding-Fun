class DetectSquares {
    Integer mat[][];
    public DetectSquares() {
        mat = new Integer[1001][1001];
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        if(mat[x][y]==null){
            mat[x][y] = 1;
        }else{
            mat[x][y]+=1;
        }
    }
    
    public int count(int[] point) {
        int px = point[0];
        int py = point[1];


        int noOfSquares = 0;

        int currRow = point[0];
        int currCol = point[1];

        while(currRow!=0 && currCol!=0){

            currRow--;
            currCol--;

            if( mat[currRow][currCol]!=null &&    //found the diagonally opposite point
                mat[currRow][py]!=null &&
                mat[px][currCol]!=null
            ){
                noOfSquares+= (mat[currRow][currCol]*mat[currRow][py]*mat[px][currCol]);
            }
        }

        currRow = point[0];
        currCol = point[1];

        while(currRow<1000 && currCol<1000){

            currRow++;
            currCol++;

            if( mat[currRow][currCol]!=null &&    //found the diagonally opposite point
                mat[currRow][py]!=null &&
                mat[px][currCol]!=null
            ){
                noOfSquares+= (mat[currRow][currCol]*mat[currRow][py]*mat[px][currCol]);
            }
        }

        currRow = point[0];
        currCol = point[1];

        while(currRow>0 && currCol<1000){

            currRow--;
            currCol++;

            if( mat[currRow][currCol]!=null &&    //found the diagonally opposite point
                mat[currRow][py]!=null &&
                mat[px][currCol]!=null
            ){
                noOfSquares+= (mat[currRow][currCol]*mat[currRow][py]*mat[px][currCol]);
            }
        }

        currRow = point[0];
        currCol = point[1];

        while(currRow<1000 && currCol>0){

            currRow++;
            currCol--;

            if( mat[currRow][currCol]!=null &&    //found the diagonally opposite point
                mat[currRow][py]!=null &&
                mat[px][currCol]!=null
            ){
                noOfSquares+= (mat[currRow][currCol]*mat[currRow][py]*mat[px][currCol]);
            }
        }


        return noOfSquares;

        

    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */