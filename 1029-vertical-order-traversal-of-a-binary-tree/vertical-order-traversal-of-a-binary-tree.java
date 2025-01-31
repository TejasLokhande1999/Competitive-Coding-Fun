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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();

        if(root==null){
            return list;
        }

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root,0,0));

        Map<Integer,List<Pair>> map = new TreeMap<>();

        while(!q.isEmpty()){

            Pair p = q.poll();
            TreeNode node = p.node;
            int line = p.line;
            int depth = p.depth;

            map.putIfAbsent(line, new ArrayList<>());

            map.get(line).add(p);

            if(node.left!=null){
                q.add(new Pair(node.left,line-1,depth+1));
            }

            if(node.right!=null){
                q.add(new Pair(node.right,line+1,depth+1));
            }

        }

        for(Map.Entry<Integer, List<Pair>> entry : map.entrySet()){

            List<Pair> pList = entry.getValue();
            Collections.sort(pList, new PairComparator());
            List<Integer> tempList = new ArrayList<>();
            for(Pair p : pList){
                tempList.add(p.node.val);
            }

            list.add(tempList);
        }

        return list;



    }
}


class Pair{

    TreeNode node;
    int line;
    int depth;

    Pair(TreeNode node, int line, int depth){
        this.node = node;
        this.line = line;
        this.depth = depth;
    }

}

class PairComparator implements Comparator<Pair>{

    public int compare(Pair p1, Pair p2){

        if(p1.depth<p2.depth){
            return -1;
        }else if(p1.depth>p2.depth){
            return 1;
        }else{


            //this is the condition where deoth is same
            //sort baed on the value

            TreeNode node1 = p1.node;
            TreeNode node2 = p2.node;

            if(node1.val<node2.val){
                return -1;
            }else if(node1.val>node2.val){
                return 1;
            }else{
                return 0;
            }

        }

    }

}