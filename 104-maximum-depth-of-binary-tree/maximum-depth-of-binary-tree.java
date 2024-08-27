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
    public int maxDepth(TreeNode root) {
        int hgt = height(root);
        return hgt;
    }

    public int height(TreeNode node){
        if(node==null){
            return 0;
        }

        int hgt = 1+Math.max(height(node.left),height(node.right));
        return hgt;

    }
}