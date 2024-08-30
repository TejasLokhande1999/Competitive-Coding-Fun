class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean reachAtlantic[][] = new boolean [m][n];
        boolean reachPacific[][] = new boolean [m][n];


        //do dfs from pacific and atlantic from left an right
        for(int i=0;i<m;i++){
            dfs(i,0,grid,reachPacific,Integer.MIN_VALUE);
            dfs(i,n-1,grid,reachAtlantic,Integer.MIN_VALUE);
        }

        //do dfs from top and botton corner

        for(int j=0;j<n;j++){
        dfs(0,j,grid,reachPacific,Integer.MIN_VALUE);
        dfs(m-1,j,grid,reachAtlantic,Integer.MIN_VALUE);

        }

        List<List<Integer>> retList =new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(reachPacific[i][j]==true && reachAtlantic[i][j]==true){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    retList.add(list);
                }
            }
        }

        return retList;

    }


    public void dfs(int row, int col, int[][] grid, boolean[][] reachable, int hgt){
        int m = grid.length;
        int n = grid[0].length;

        if(row<0||row>=m|| col<0 || col>=n || reachable[row][col] || grid[row][col]<hgt){
            return;
        }

        reachable[row][col]=true;

        dfs(row+1,col,grid,reachable,grid[row][col]);
        dfs(row-1,col,grid,reachable,grid[row][col]);
        dfs(row,col+1,grid,reachable,grid[row][col]);
        dfs(row,col-1,grid,reachable,grid[row][col]);

    }
}