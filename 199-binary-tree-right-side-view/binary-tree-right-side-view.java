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
    List<Integer> list = new ArrayList<Integer>();

    public List<Integer> rightSideView(TreeNode root) {
        
        func(root,0);
        return list;

    }

    public void func(TreeNode node, int currDepth){

        if(node==null){
            return;
        }

        if(currDepth==list.size()){
            list.add(node.val);
        }

        func(node.right,currDepth+1);
        func(node.left,currDepth+1);

    }
}