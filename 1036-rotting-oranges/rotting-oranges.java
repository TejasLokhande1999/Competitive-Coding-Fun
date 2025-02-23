class Solution {
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];

        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    //these are the rotten oranges
                    q.add(new Pair(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

       return  bfs(q,visited,grid);

    }

        public int bfs(Queue<Pair> q, boolean visited[][], int grid[][]){
        int globalTime = 0;
        int m = grid.length;
        int n = grid[0].length;
        while(!q.isEmpty()){

            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int time = p.time;
            globalTime = Math.max(globalTime,time);
            //trace the 4 directions 

            //1,0  -1,0  0,-1  0,1
            int rArr[] = {1,-1,0,0};
            int cArr[] = {0,0,-1,1};
            
            for(int k=0;k<4;k++){

                int nRow = rArr[k]+row;
                int nCol = cArr[k]+col;


                //check if within bounds

                if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && !visited[nRow][nCol]
                && grid[nRow][nCol]==1){
                    q.add(new Pair(nRow,nCol,time+1));
                    visited[nRow][nCol]=true;
                }

            }
        }

        //

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){

                    if(grid[i][j]==1 && !visited[i][j]){
                        return -1;
                    }

                }
            }


            return globalTime;


        }
}

class Pair{
    int row;
    int col;
    int time;

    Pair(int row, int col, int time){
        this.row =row;
        this.col = col;
        this.time = time;
    }
}