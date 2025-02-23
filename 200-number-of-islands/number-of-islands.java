class Solution {

    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    bfs(i,j,grid,visited);
                    count+=1;
                }
            }
        }

        return count;

    }

    public void bfs(int row, int col, char[][] grid, boolean[][] visited){

        Queue<Pair> q = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;
        q.add(new Pair(row,col));
        visited[row][col]=true;

        while(!q.isEmpty()){

            Pair p = q.poll();

            int r = p.row;
            int c = p.col;

            int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};

            for(int i=0;i<4;i++){
                
                int nRow = r+dir[i][0];
                int nCol = c+dir[i][1];

                //check if within limits

                if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && !visited[nRow][nCol]
                && grid[nRow][nCol]=='1'){

                    q.add(new Pair(nRow,nCol));
                    visited[nRow][nCol] = true;
                }

            }

        }


    }
}

class Pair{
    int row;
    int col;

    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}



//            0,1
//-1,0                      1,0
//            0,-1