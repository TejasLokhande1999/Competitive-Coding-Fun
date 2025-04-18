class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(!visited[i][j] && grid[i][j]=='1'){
                    count+=1;
                    dfs(i,j,grid,visited);
                }

            }
        }

        return count;
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;

        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || grid[i][j]=='0'){
            return;
        }

        visited[i][j]= true;

        dfs(i+1,j,grid,visited);
        dfs(i-1,j,grid,visited);
        dfs(i,j+1,grid,visited);
        dfs(i,j-1,grid,visited);
    }
}