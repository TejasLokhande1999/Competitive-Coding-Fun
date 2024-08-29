class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        int count[] = new int[1];
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 &&!visited[i][j]){
                    count[0]=0;
                    dfs(i,j,grid,visited,count);
                    max=Math.max(count[0],max);
                }
            }
        }

        return max;
    }

        public void dfs(int row, int col,int grid[][], boolean visited[][], int count[]){

            int m = grid.length;
            int n = grid[0].length;

            if(row<0 || col<0 || row>=m || col>=n || visited[row][col] || grid[row][col]==0){
                return;
            }

                visited[row][col] = true;
                count[0]+=1;


            dfs(row+1,col,grid,visited,count);
            dfs(row-1,col,grid,visited,count);
            dfs(row,col+1,grid,visited,count);
            dfs(row,col-1,grid,visited,count);

            
        }
    
}