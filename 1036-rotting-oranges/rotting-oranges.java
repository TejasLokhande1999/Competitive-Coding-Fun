class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=true;
                }
            }
        }

        int tmax=0;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int row =p.row;
            int col =p.col;
            int time = p.time;

            tmax= Math.max(tmax,time);

            int nRow[] = {-1,0,1,0};
            int nCol[] = {0,1,0,-1};

            for(int k=0;k<4;k++){
                int newRow = row+nRow[k];
                int newCol = col+nCol[k];

                //check the condition
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && !visited[newRow][newCol] && grid[newRow][newCol]==1){
                    //then visit
                    //we are visiting the unvisited 1 node
                    q.add(new Pair(newRow, newCol, time+1));
                    visited[newRow][newCol]=true;
                }
            }

        }


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    return -1;
                }
            }
        }

        return tmax;




    }
}

class Pair{

    int row;
    int col;
    int time;

    Pair(int row, int col, int time){
        this.row =row;
        this.col=col;
        this.time = time;
    }

}