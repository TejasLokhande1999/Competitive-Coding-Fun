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
    public int count=0;
    public int goodNodes(TreeNode root) {
        
        height(root,Integer.MIN_VALUE);

        return count;


    }

    public void height(TreeNode node , int max){

        if(node==null){
            return;
        }

        if(node.val>=max){
            count+=1;
        }

        max = Math.max(max,node.val);

        height(node.left,max);
        height(node.right,max);

    }
}