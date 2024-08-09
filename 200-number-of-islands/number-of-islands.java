class Pair{
    int row;
    int col;

    Pair(int row, int col){
        this.row=row;
        this.col=col;
    }

}

class Solution {
    public int numIslands(char[][] grid) {
        

        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];

        int counter=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    //apply bfs
                    bfs(i,j,grid,visited,m,n);
                    counter++;
                }
            }
        }

        return counter;

    }

// public void bfs(int i, int j, char grid[][], boolean visited[][], int m, int n) {
//     Queue<Pair> q = new LinkedList<>();
//     q.add(new Pair(i, j));
//     visited[i][j] = true;  // Mark as visited when adding to the queue

//     // Directions array for moving up, down, left, right
//     int[] dirRow = {-1, 1, 0, 0};
//     int[] dirCol = {0, 0, -1, 1};

//     while (!q.isEmpty()) {
//         Pair node = q.poll();
//         int row = node.row;
//         int col = node.col;

//         // Explore neighbors in four possible directions
//         for (int k = 0; k < 4; k++) {
//             int checkRow = row + dirRow[k];
//             int checkCol = col + dirCol[k];

//             // Check if the new position is within bounds, is land ('1'), and not visited yet
//             if (checkRow >= 0 && checkRow < m && checkCol >= 0 && checkCol < n && grid[checkRow][checkCol] == '1' && !visited[checkRow][checkCol]) {
//                 q.add(new Pair(checkRow, checkCol));
//                 visited[checkRow][checkCol] = true;  // Mark as visited when adding to the queue
//             }
//         }
//     }
// }


    public void bfs(int i, int j, char grid[][], boolean visited[][], int m, int n){

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(i,j));
        visited[i][j] = true;

        int[] nrow = {-1, 1, 0, 0};
        int[] ncol = {0, 0, -1, 1};

        while(!q.isEmpty()){

            Pair node = q.poll();
            int row = node.row;
            int col = node.col;

            for(int k =0; k<4;k++){
    
                     int checkRow = nrow[k] + row;
                     int checkCol = ncol[k] + col;

                    if(checkRow>=0 && checkRow<m && checkCol>=0 && checkCol<n && grid[checkRow][checkCol]=='1' && !visited[checkRow][checkCol]){

                      //    visited[checkRow][checkCol] = true;
                        q.add(new Pair(checkRow,checkCol));
                                    visited[checkRow][checkCol] = true;

                    }
                
            }

        }


    }
}