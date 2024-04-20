class Solution {
    // public int[][] findFarmland(int[][] land) {


    // ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

    //     for(int i=0; i<land.length;i++){
    //         for(int j=0;j<land[0].length;j++){
    //             if(land[i][j]==1){
    //                 ArrayList<Integer> temp = new ArrayList<Integer>();
    //                 temp.add(i);
    //                 temp.add(j);
    //                 ArrayList<Integer> temp2 = new ArrayList<Integer>();
    //                 temp2 = dfs(i,j,land);
    //                 temp.addAll(temp2);
    //                 list.add(temp);
    //             }
    //         }
    //     }
    //     int[][] array = new int[list.size()][];

    //     // Loop through each list in the ArrayList
    //     for (int i = 0; i < list.size(); i++) {
    //         ArrayList<Integer> rowList = list.get(i);
    //         // Initialize each row in the 2D array with the size of the list at that index
    //         array[i] = new int[rowList.size()];
    //         // Copy each element from the list to the 2D array
    //         for (int j = 0; j < rowList.size(); j++) {
    //             array[i][j] = rowList.get(j);
    //         }
    //     }

    //     return array;


    // }

    // public ArrayList<Integer> dfs(int i, int j, int grid[][]){
    //     ArrayList<Integer> list = new ArrayList<Integer>();

    //     //check first condition.
    //     //within the limits
    //     if(i<grid.length-1 && j<grid[0].length-1){
    //         if(grid[i+1][j]==0 && grid[i][j+1]==0)
    //         {
    //             list.add(i);
    //             list.add(j);
    //             return list;
    //         }
    //     }

    //     if(i<grid.length-1 && j==grid[0].length-1){
    //         if(grid[i+1][j]==0){
    //             list.add(i);
    //             list.add(j);
    //             return list;            
    //             }
    //     }

    //     if(i==grid.length-1 && j==grid[0].length-1){
    //             list.add(i);
    //             list.add(j);
    //             return list;
    //          }

    //     if(i==grid.length-1 && j<grid[0].length-1){
    //           if(grid[i][j+1]==0){
    //             list.add(i);
    //             list.add(j);
    //             return list;
    //         }
    //     }
    //     //else apply dfs
    //     grid[i][j]=2;
        
    //     if(i<grid.length-1)
    //         if(grid[i+1][j]!=0 && grid[i+1][j]!=2)
    //             dfs(i+1,j,grid);
    //     if(i>0)
    //         if(grid[i-1][j]!=0 && grid[i-1][j]!=2)
    //             dfs(i-1,j,grid);
    //     if(j<grid[0].length-1)
    //         if(grid[i][j+1]!=0 && grid[i][j+1]!=2)
    //             dfs(1,j+1,grid);
    //     if(j>0)
    //         if(grid[i][j-1]!=0 && grid[i][j-1]!=2)
    //             dfs(1,j-1,grid);

    //     return list;


    // }

     public int[][] findFarmland(int[][] land) {
        List<int[]> results = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {  // Found the top-left corner of a new farmland
                    int[] boundary = new int[]{i, j, i, j};  // top-left and bottom-right corners
                    dfs(i, j, land, boundary);
                    results.add(new int[]{boundary[0], boundary[1], boundary[2], boundary[3]});
                }
            }
        }
        return results.toArray(new int[results.size()][]);
    }

    public void dfs(int i, int j, int[][] grid, int[] boundary) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;  // Mark as visited
        // Expand the boundary
        boundary[2] = Math.max(boundary[2], i);
        boundary[3] = Math.max(boundary[3], j);
        // Recurse in all four directions
        dfs(i + 1, j, grid, boundary);
        dfs(i - 1, j, grid, boundary);
        dfs(i, j + 1, grid, boundary);
        dfs(i, j - 1, grid, boundary);
    }

}