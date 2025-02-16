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
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inorder(root,list);

        int minDiff = Integer.MAX_VALUE;

        for(int i=1;i<list.size();i++){
            int diff = list.get(i)-list.get(i-1);

            minDiff = Math.min(minDiff,diff);
        }

        return minDiff;


    }

    public void inorder(TreeNode node, List<Integer> list){
        if(node==null){
            return;
        }
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }
}