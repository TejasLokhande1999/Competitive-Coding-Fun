class Solution {
    public int findCircleNum(int[][] isConnected) {

        int V = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V+1;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i+1).add(j+1);
                }
            }
        }

        boolean visited[] = new boolean[V+1];

        int counter=0;
        for(int i=1;i<=V;i++){      //because 1 based indexing
            if(!visited[i]){
                dfs(i,adj,visited);
                counter++;
            }
        }   


        return counter;

    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean visited[]){

        visited[node] = true;

        ArrayList<Integer> list = adj.get(node);

        for(Integer currNode : list){
            if(!visited[currNode]){
                dfs(currNode,adj,visited);
            }
        }
    }
}