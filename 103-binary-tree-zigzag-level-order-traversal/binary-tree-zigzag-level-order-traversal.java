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


        Queue<TreeNode> q = new LinkedList<>();

        if(root==null){
            return list;
        }

        q.add(root);
        int count=0;
        while(!q.isEmpty()){

            int level = q.size();

            List<Integer> subList = new ArrayList<>();

            for(int i=0;i<level;i++){
                TreeNode node = q.poll();

                if(node.left!=null){
                    q.add(node.left);
                }

                if(node.right!=null){
                    q.add(node.right);
                }

                subList.add(node.val);

            }

            if(count%2==0)
                list.add(subList);
            else{
                Collections.reverse(subList);
                list.add(subList);
            }

            count+=1;

        }

        return list;

    }
}