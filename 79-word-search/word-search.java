class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n = board[0].length;
        boolean retValue = false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean visited[][] = new boolean[m][n];
                retValue = dfs(i,j,board,visited,word,0);
                if(retValue)
                    return true;
            }
        }

        return false;
    }

    public boolean dfs(int i, int j, char[][] grid, boolean[][] visited, String word, int index){

        int row = grid.length;
        int col = grid[0].length;
        if(index>=word.length()){
            return true;
        }else if(i<0 || i>=row || j<0 || j>=col || visited[i][j] || grid[i][j]!=word.charAt(index) ){
            return false;
        }else{
            visited[i][j]=true;
            boolean retBoolean= dfs(i+1,j,grid,visited,word,index+1)||
            dfs(i-1,j,grid,visited,word,index+1)||
            dfs(i,j+1,grid,visited,word,index+1)||
            dfs(i,j-1,grid,visited,word,index+1);

            visited[i][j] = false;
            return retBoolean;
        }

    }
}