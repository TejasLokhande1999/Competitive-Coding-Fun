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

  //  public int perimeter=0;
    public Set<Pair> visit = new HashSet<Pair>();
    public int islandPerimeter(int[][] grid) {
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return dfs(i,j,grid);
                }
            }
        }

        return 0;

    }

    public int dfs(int i, int j, int grid[][]){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0){
            return 1;
        }
        Pair p = new Pair(i,j);
        if(visit.contains(p)){
            return 0;
        }

    // int perimeter=0;
    //     visit.add(p);
    //     perimeter=dfs(i,j+1,grid);
    //     perimeter+= dfs(i-1,j,grid);
    //     perimeter+=dfs(i,j-1,grid);
    //     perimeter+=dfs(i+1,j,grid);
            visit.add(p);
        int perimeter = 0;
        perimeter = dfs(i, j + 1, grid);
        perimeter += dfs(i - 1, j, grid);
        perimeter += dfs(i, j - 1, grid);
        perimeter += dfs(i + 1, j, grid);

        return perimeter;

    }

}