class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        

        Queue<Pair> q= new LinkedList<>();
        Pair pair = new Pair(0,0,1);
        q.add(pair);
        int n = grid.length;
        //int n = grid[0].length;

        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }
        boolean visited[][] = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                visited[i][j] = false;
            }
        }

        while(!q.isEmpty()){

            Pair p = q.poll();

            int x = p.x;
            int y = p.y;
            int val = p.val;

            if(x==n-1 && y==n-1){
                return val;
            }

            int directions[][] ={{-1,1},
                                 {0,1},
                                 {1,1},
                                 {1,0},
                                 {1,-1},
                                 {0,-1},
                                 {-1,-1},
                                 {-1,0}};



            for(int i=0;i<8;i++){
                int row = x+directions[i][0];
                int col = y+directions[i][1];

                if(row>=0 && row<=n-1 && col>=0 && col<=n-1 && 
                !visited[row][col] && grid[row][col]==0){
                    q.add(new Pair(row,col,val+1));
                    visited[row][col] = true;
                }

            }


        }


        return -1;

    }
}

class Pair{

    int x;
    int y;
    int val;

    Pair(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }

}


    // -1,1      0,1     1,1
    // -1,0             1,0
    // -1,-1     0,-1    1,-1