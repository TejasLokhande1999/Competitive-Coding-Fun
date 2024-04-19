class Pair{
    private int i;
    private int j;

    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }

     @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return i == pair.i && j == pair.j;
    }

    @Override
    public int hashCode() {
        return 31 * i + j; // Simple hash code. Ensure it distributes well for your grid size.
    }
}

class Solution {


    public Set<Pair> visit = new HashSet<Pair>();


    public int numIslands(char[][] grid) {
        
        int ans=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    ans+=1;
                }
            }
        }

        return ans;
        
    }

      public void dfs(int i, int j, char grid[][]){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return;
        }
        if(grid[i][j]!='1')
            return;
            
        grid[i][j]='2';
        dfs(i, j + 1, grid);
        dfs(i - 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i + 1, j, grid);

    }

    

}