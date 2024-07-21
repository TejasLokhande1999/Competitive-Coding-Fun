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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();

        boolean isOdd = true;
        if(root==null)
            return list;

        Queue<TreeNode> q = new LinkedList<TreeNode>();


        q.add(root);
        int counter=0;

        while(!q.isEmpty()){
            int levelNo = q.size();

            List<Integer> temp = new ArrayList<Integer>();

            for(int i=0;i<levelNo;i++){
                if(q.peek().left!=null)
                    q.add(q.peek().left);

                if(q.peek().right!=null)
                    q.add(q.peek().right);

                //Just chekc the level
                if(counter%2==0){
                    temp.add(q.poll().val);
                }else{
                    temp.add(0,q.poll().val);
                }
            }

            counter+=1;

            list.add(temp);

        }

        return list;
    }
}