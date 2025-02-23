class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int V = isConnected.length;

        boolean visited[] = new boolean[V];
        V = V;
        int count=0;

        for(int i=0;i<V;i++){

            if(!visited[i]){
                count+=1;
                dfs(i,isConnected, visited);
            }
        }

        return count;

    }

    public void dfs(int currNode, int[][] grid, boolean visited[]){

        visited[currNode] = true;

        for(int i=0;i<grid[0].length;i++){
            int node = grid[currNode][i];
            if(!visited[i] && node==1){
                dfs(i,grid,visited);
            }
        }
    }
}