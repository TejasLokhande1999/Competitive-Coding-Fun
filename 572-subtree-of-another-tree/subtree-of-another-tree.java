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
        
        Queue<TreeNode> q = new LinkedList<>();

        if(root==null){
            return false;
        }

        q.add(root);

        while(!q.isEmpty()){

            TreeNode node= q.poll();

            if(node.val==subRoot.val){
                boolean flag = isIdentical(node,subRoot);
                if(flag){
                    return true;
                }
            }

            if(node.left!=null){
                q.add(node.left);
            }

            if(node.right!=null){
                q.add(node.right);
            }

        }

        return false;

    }

    public boolean isIdentical(TreeNode node1, TreeNode node2){
        if(node1==null && node2==null){
            return true;
        }

        if(node1==null || node2==null){
            return false;
        }

        if(node1.val==node2.val){
            return isIdentical(node1.left,node2.left)&&isIdentical(node1.right,node2.right);
        }

        return false;
    }
}