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
    if(root==null){
        return list;
    }
     Queue<TreeNode> q = new LinkedList<>();

     q.add(root);

    int counter=0;
     while(!q.isEmpty()){
        int levelNo = q.size();
        List<Integer> subList = new ArrayList<>();

        for(int i=0;i<levelNo;i++){
            TreeNode front = q.poll();
            if(front.left!=null)
                q.add(front.left);

            if(front.right!=null)
                q.add(front.right);
            
            if(counter%2==0)
                subList.add(front.val);
            else
                subList.add(0,front.val);
        }
        counter++;
        list.add(subList);
     }

     return list;

    }
}