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
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        if(root==null){
            return list;
        }
        q.add(root);

        while(!q.isEmpty()){
            int levelNo = q.size();
            List<Integer> subList = new ArrayList<Integer>();
            for(int i=0;i<levelNo;i++){
                TreeNode front = q.poll();
                if(front.left!=null){
                    q.add(front.left);
                }
                if(front.right!=null){
                    q.add(front.right);
                }
                subList.add(front.val);
            }
            list.add(subList);
        }

        boolean even = true;

        List<List<Integer>> retList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            List<Integer> temp = list.get(i);
            if(i%2==0){
                retList.add(temp);
            }else{
                Collections.reverse(temp);
                retList.add(temp);
            }
        }

        return retList;
    }
}