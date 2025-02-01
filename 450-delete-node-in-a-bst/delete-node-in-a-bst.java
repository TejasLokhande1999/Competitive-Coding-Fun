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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root==null){
            return null;
        }

        if(root.val<key){
            root.right = deleteNode(root.right,key);
        }else if(root.val>key){
            root.left = deleteNode(root.left,key);
        }else{

            //now root.data = key
            //relace the val of data with inorder successor data

            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            TreeNode successor = getInorderSuccessor(root.right);

            root.val = successor.val;

            root.right = deleteNode(root.right, successor.val);

        }
        return root;

    }

    public TreeNode getInorderSuccessor(TreeNode node){

        while(node.left!=null){
            node = node.left;
        }

        return node;
    }
}