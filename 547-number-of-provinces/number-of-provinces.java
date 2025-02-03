class Solution {
    public int findCircleNum(int[][] isConnected) {
        //change to adj matrix;

        int V = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();


        for(int i=0;i<V+1;i++){
            adj.add(new ArrayList<>());
        }
        int n = isConnected.length;
        int m = isConnected[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count = 0;

        boolean visited[] = new boolean[V+1];
        for(int i=0;i<V;i++){
            
            if(!visited[i]){
            count+=1;
            dfs(i,visited,adj);

            }

        }

        return count;

    }

    public void dfs(int currNode, boolean[] visited, ArrayList<ArrayList<Integer>> adj){

        visited[currNode] = true;

        ArrayList<Integer> list = adj.get(currNode);

        for(int i=0;i<list.size();i++){

            int node = list.get(i);
            if(!visited[node]){
                dfs(node,visited,adj);
            }

        }

    }
}