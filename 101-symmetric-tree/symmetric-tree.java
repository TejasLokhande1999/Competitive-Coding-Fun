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
    public boolean isSymmetric(TreeNode root) {
        
        return isSymm(root.left,root.right);
    }

    public boolean isSymm(TreeNode node1, TreeNode node2){

        if(node1==null && node2==null){
            return true;
        }

        if(node1==null || node2==null){
            return false;
        }

        if(node1.val==node2.val)
            return isSymm(node1.left,node2.right)&&isSymm(node1.right,node2.left);

        return false;
    }
}