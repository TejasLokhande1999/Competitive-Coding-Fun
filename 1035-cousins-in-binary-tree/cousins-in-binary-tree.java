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
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer,Pair> map = new HashMap<>();
        //Map of child to parent

        if(root==null){
            return false;
        }

        Queue<Pair> q =new LinkedList<>();

        q.add(new Pair(root,0));
        map.put(root.val,new Pair(null,0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.node;
            int level = p.level;

            if(node.left!=null){
                q.add(new Pair(node.left,level+1));
                map.put(node.left.val, new Pair(node, level+1));
            }

            if(node.right!=null){
                q.add(new Pair(node.right, level+1));
                map.put(node.right.val, new Pair(node, level+1));
            }

        }

        Pair p1 = map.get(x);
        Pair p2 = map.get(y);

        if(p1.node!=p2.node){
            if(p1.level==p2.level){
                return true;
            }
        }

        return false;

    }
}

class Pair{

    TreeNode node;
    int level;

    Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}