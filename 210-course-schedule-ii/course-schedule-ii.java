class Solution {
    public int[] findOrder(int numCourses, int[][] prereq) {
        int V = numCourses;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        int m = prereq.length;
        //create adj
        for(int i=0;i<m;i++){
            int u = prereq[i][1];
            int v = prereq[i][0];

            adj.get(u).add(v);

        }

        int indegree[] = new int[V];

        for(int i=0;i<adj.size();i++){
            List<Integer> list = adj.get(i);
            for(int j=0;j<list.size();j++){
                indegree[list.get(j)]+=1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){

            int currNode = q.poll();
            topo.add(currNode);

            List<Integer> temp = adj.get(currNode);
            for(int i=0;i<temp.size();i++){
                int node = temp.get(i);

                indegree[node]-=1;

                if(indegree[node]==0){
                    q.add(node);
                }
            }

        }

        if(topo.size()==V){
       int arr[] = new int[V];

        for(int i=0;i<topo.size();i++){
            arr[i] = topo.get(i);
        }

        return arr;
        }
        return new int[0];
 
    }
}