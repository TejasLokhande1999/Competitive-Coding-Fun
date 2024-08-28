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
        Queue<Pair>q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();

        List<Pair> pList = new ArrayList<>();
        q.add(new Pair(root,0,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            pList.add(p);
            TreeNode node = p.node;
            int col = p.col;
            int row = p.row;
        //map.putIfAbsent(line, new ArrayList<>());
        //map.get(line).add(node.val);
    
        if(node.left!=null){
            q.add(new Pair(node.left,col-1,row+1));
        }

        if(node.right!=null){
            q.add(new Pair(node.right,col+1,row+1));
        }
    }

    Collections.sort(pList, new PairComparator());

    List<List<Integer>> list = new ArrayList<>();
    for(int i=0;i<pList.size();i++){
        Pair p = pList.get(i);
        int line = p.col;
        map.putIfAbsent(line, new ArrayList<>());
        map.get(line).add(p.node.val);
    }
    for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
        list.add(entry.getValue());
    }

    return list;
}

}



class Pair{
    
    TreeNode node;
    int col;
    int row;
    
    Pair(TreeNode node, int col, int row){
        this.node = node;
        this.col = col;
        this.row = row;
    }
    
    
}

class PairComparator implements Comparator<Pair>{

    public int compare(Pair p1, Pair p2){
        if(p1.col>p2.col){
            return 1;
        }else if(p1.col<p2.col){
            return -1;
        }else{
            //tie so sort by row
            if(p1.row>p2.row){
                return 1;
            }else if(p1.row<p2.row){
                return -1;
            }else{
                //sprt by val
                if(p1.node.val>p2.node.val){
                    return 1;
                }else if(p1.node.val<p2.node.val){
                    return -1;
                }else{
                    return 0;
                }

            }

        }
    }

}