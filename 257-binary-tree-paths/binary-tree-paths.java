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
    List<String> list = new ArrayList<>();
    List<Integer> arr = new ArrayList<>();

    //String str="";
    public List<String> binaryTreePaths(TreeNode root) {
        inorder(root);
        return list;
    }

    public void inorder(TreeNode node){
        if(node==null){
            return;
        }
        arr.add(node.val);
        if(node.left==null && node.right==null){
            list.add(printInFormat(arr));
        }
        inorder(node.left);
        inorder(node.right);
        arr.remove(arr.size()-1);
        //str = str.substring(0,str.length()-1);
    }

    public String printInFormat(List<Integer> arr){
        String str="";

        for(int i=0;i<arr.size()-1;i++){
            str+=arr.get(i);
            str+="->";
        }
        str+=arr.get(arr.size()-1);
        return str;
    }
}
