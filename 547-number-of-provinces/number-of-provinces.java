class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean visited[] = new boolean[V];

        int counter=0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                counter+=1;
                dfs(i,visited,isConnected);
            }
        }

        return counter;
    }

    public void dfs(int currNode, boolean visited[], int isConnected[][]){

        visited[currNode] = true;

        for(int i=0;i<isConnected.length;i++){
            if(!visited[i] && isConnected[currNode][i]==1){
                dfs(i,visited,isConnected);
            }
        }

    }
}