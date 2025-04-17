/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {

        if(root.left==null && root.right==null && root.val==start)
            return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        inorder(root,null,map);
        //map is generated
        //ow do bfs
        int time = bfs(start,map);

        return time;
    }

    public int bfs(int start,Map<Integer, List<Integer>> map){

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        int time=-1;
        while(!q.isEmpty()){
            time+=1;
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                int currNode  = q.poll();      
                for(int node : map.get(currNode)){
                
                    if(!visited.contains(node)){
                        q.add(node);
                        visited.add(node);
                    }
                }
            }
            
        }

        return time;

    }

    public void inorder(TreeNode node, TreeNode parent,Map<Integer, List<Integer>> map){

        if(node==null)
            return;
        if(parent!=null){

            map.putIfAbsent(node.val, new ArrayList<>());
            map.putIfAbsent(parent.val, new ArrayList<>());

            map.get(node.val).add(parent.val);
            map.get(parent.val).add(node.val);
         
        }
        inorder(node.left,node,map);
        inorder(node.right,node,map);
    }
}