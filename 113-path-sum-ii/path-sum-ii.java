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
    List<List<Integer>> retList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list =new ArrayList<>();
        inorder(root,targetSum,0,list);
        return retList;
    }

    public void inorder(TreeNode node,int target, int sum, List<Integer> list){
        if(node==null){
            return;
        }

        list.add(node.val);
        sum+=node.val;

        if(node.left==null && node.right==null){
            if(sum==target){
                retList.add(new ArrayList<>(list));
            }
        }

        inorder(node.left,target,sum,list);

        inorder(node.right,target,sum,list);
        list.remove(list.size()-1);


    }
}