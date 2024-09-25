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
    public boolean isCousins(TreeNode root, int x, int y) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorder(root,list1,x);
        inorder(root,list2,y);

        for(int i=0;i<list1.size();i++){
            System.out.print(list1.get(i)+" ");
        }

        System.out.println();
        

         for(int i=0;i<list2.size();i++){
            System.out.print(list2.get(i)+" ");
        }

        if(list1.size()!=list2.size()){
            return false;
        }else{
            int n = list1.size();
            if(list1.get(n-2)!=list2.get(n-2)){
                return true;
            }
        }
        return false;
    }

    public boolean inorder(TreeNode node, List<Integer> list, int data){

        if(node==null){
            return false;
        }

        list.add(node.val);

        if(node.val==data){
            return true;
        }

        if(inorder(node.left,list,data) || inorder(node.right,list,data)){
            return true;
        }

        list.remove(list.size()-1);
        return false;

    }
}