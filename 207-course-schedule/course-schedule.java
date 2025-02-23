class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();

        int V = numCourses;

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] arr : prerequisites){
            int u = arr[1];
            int v = arr[0];
            adj.get(u).add(v);
        }

        //generate indegree

        int indegree[] = new int[V];
        for(List<Integer> list : adj){
            for(Integer i : list){
                indegree[i]+=1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();
        boolean visited[] = new boolean[V];

        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
                visited[i] = true;
            }
        }


        while(!q.isEmpty()){

            int currNode = q.poll();
            topo.add(currNode);

            List<Integer> l = adj.get(currNode);

            for(Integer i : l){

                if(!visited[i]){
                    indegree[i]--;
                    if(indegree[i]==0){
                        q.add(i);
                        
                    }
                }
            }

        }

        if(topo.size()==V){
            return true;
        }

        return false;




    }
}