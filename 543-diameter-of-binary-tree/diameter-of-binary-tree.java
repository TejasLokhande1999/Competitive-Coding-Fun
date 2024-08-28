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
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root==null){
            return 0;
        }
        int lh = hgt(root.left);
        int rh = hgt(root.right);

        return Math.max(lh+rh, Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));
    }

    public int hgt(TreeNode node){

        if(node==null){
            return 0;
        }

        int lh = hgt(node.left);
        int rh = hgt(node.right);

        return 1+Math.max(lh,rh);
    }
}