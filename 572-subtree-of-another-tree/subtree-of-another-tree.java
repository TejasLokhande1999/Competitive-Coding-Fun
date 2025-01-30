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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return inorder(root,subRoot);
    }

    public boolean inorder(TreeNode node,TreeNode subRoot){

        if(node==null){
            return false;
        }

        
        if(isIdentical(node,subRoot)){
            return true;
        }

        boolean v1 = inorder(node.left,subRoot);
        boolean v2 = inorder(node.right,subRoot);

        return v1||v2;
    }


    public boolean isIdentical(TreeNode node1, TreeNode node2){

        if(node1==null && node2==null){
            return true;
        }

        if(node1==null || node2==null || node1.val!=node2.val){
            return false;
        }

        return isIdentical(node1.left, node2.left)&&isIdentical(node1.right, node2.right);

    }
}