class Pair{

    int row;
    int col;
    int time;

    Pair(int row, int col, int time){
        this.row = row;
        this.col=col;
        this.time=time;
    }

}

class Solution {
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        if(m==1 && n==1){
            if(grid[0][0]==0){
                return 0;
            }
            if(grid[0][0]==1){
                return -1;
            }
        }
        int visited[][] = new int[m][n];

        int tmax = 0;

        Queue<Pair> q = new LinkedList<Pair>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }
            }
        }

        

        while(!q.isEmpty()){

            Pair node = q.poll();

            int row = node.row;
            int col = node.col;
            int time = node.time;

            tmax = Math.max(time, tmax);

            int nrow[] = {-1,0,1,0};
            int ncol[] = {0,1,0,-1};


            for(int k=0;k<4;k++){

                int checkRow = row + nrow[k];
                int checkCol = col + ncol[k];

                //check if out of bounds

                if(checkRow>=0 && checkRow<m &&
                   checkCol>=0 && checkCol<n &&
                   grid[checkRow][checkCol]==1 && 
                   visited[checkRow][checkCol]!=2){

                    q.add(new Pair(checkRow, checkCol, time+1));
                    visited[checkRow][checkCol]=2;

                    }
                
            }
        }


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && visited[i][j]!=2){
                    return -1;
                }
            }
        }

        return tmax;

    }
}