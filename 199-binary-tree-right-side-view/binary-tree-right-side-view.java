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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList<Integer>();
        
        rightView(root,0,list);

    return list;

    }

    public void rightView(TreeNode node, int level, List<Integer> list){

        if(node ==null){
            return;
        }

        if(list.size()==level){
            list.add(node.val);
        }

        rightView(node.right,level+1,list);
        rightView(node.left,level+1,list);

    }

}