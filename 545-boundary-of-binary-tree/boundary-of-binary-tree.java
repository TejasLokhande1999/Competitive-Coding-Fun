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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        res.add(root.val);
        boolean isRootAdded = true;
        getLeftBoundary(root,res);
        getLeaf(root,res, isRootAdded);
        getRightBoundary(root,res);
        return res;
    }

    public void getLeftBoundary(TreeNode root, List<Integer> res){
        TreeNode curr = root.left;

        while(curr!=null){
            if(!isLeaf(curr)){
                res.add(curr.val);
            }
            if(curr.left!=null){
                curr = curr.left;
            }else{
                curr = curr.right;
            }       
    }
    }

        public void getRightBoundary(TreeNode root,List<Integer> res){
            TreeNode curr = root.right;
            Stack<Integer> s = new Stack<>();

            while(curr!=null){
                if(!isLeaf(curr)){
                    s.add(curr.val);
                }
                if(curr.right!=null){
                    curr=curr.right;
                }else{
                    curr = curr.left;
                }
            }

            while(!s.isEmpty()){
                res.add(s.pop());
            }

        }

        public void getLeaf(TreeNode root, List<Integer> res,boolean isRoot){

            if(root==null){
                return;
            }
            if(isLeaf(root) && !isRoot){
                res.add(root.val);
            }
            isRoot=false;
            getLeaf(root.left,res,isRoot);
            getLeaf(root.right,res,isRoot);
            
        }

        boolean isLeaf(TreeNode node){
            if(node.left==null && node.right==null){
                return true;
            }
            return false;
        }

    }
