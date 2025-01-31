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
    public boolean isBalanced(TreeNode root) {
        
        int val = height(root);

        if(val==-1){
            return false;
        }

        return true;


    }

    public int height(TreeNode node){
        if(node==null){
            return 0;
        }

        int lh = height(node.left);
        if(lh==-1){
            return -1;
        }
        int rh = height(node.right);
        if(rh==-1){
            return -1;
        }
        int diff = Math.abs(lh-rh);
        if(diff>=2)
            return -1;
        return 1+Math.max(lh,rh);


    }
}