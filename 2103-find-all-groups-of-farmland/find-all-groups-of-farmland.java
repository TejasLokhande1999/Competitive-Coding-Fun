class Solution {
    public int[][] findFarmland(int[][] land) {
        
        int m = land.length;
        int n = land[0].length;

        boolean[][] visited = new boolean[m][n];

        List<int[]> result = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(land[i][j]==1 && !visited[i][j]){
                    int boundary[] = {i,j,i,j};

                    dfs(i,j,land,visited,boundary);
                    result.add(new int[]{boundary[0],boundary[1],boundary[2],boundary[3]});
                }

            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public void dfs(int i, int j, int[][] grid, boolean visited[][], int boundary[]){

        int m = grid.length;
        int n = grid[0].length;

        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || grid[i][j]==0){
            return;
        }

        visited[i][j] = true;

        boundary[2] = Math.max(boundary[2],i);
        boundary[3] = Math.max(boundary[3],j);

        dfs(i+1,j,grid,visited,boundary);
        dfs(i-1,j,grid,visited,boundary);
        dfs(i,j+1,grid,visited,boundary);
        dfs(i,j-1,grid,visited,boundary);

    }
}