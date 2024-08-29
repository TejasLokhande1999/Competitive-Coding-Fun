class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int counter=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(i,j,visited,grid);
                    counter++;
                }
            }
        }

        return counter;
    }

    public void dfs(int row, int col, boolean visited[][], char grid[][]){

        int m = grid.length;
        int n = grid[0].length;

        if(row<0 || row>=m || col<0 || col>=n || grid[row][col]=='0' || visited[row][col]){         //already visited
            return;
        }

        visited[row][col]=true;

        dfs(row+1,col,visited,grid);
        dfs(row-1,col,visited,grid);
        dfs(row,col+1,visited,grid);
        dfs(row,col-1,visited,grid);

    }
}