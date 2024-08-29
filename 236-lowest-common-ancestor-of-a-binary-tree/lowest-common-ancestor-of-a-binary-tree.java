/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listP = new ArrayList<>();
        List<TreeNode> listQ = new ArrayList<>();

        inorder(root,p,listP);
        inorder(root,q,listQ);

        int n = listP.size()>listQ.size()?listQ.size():listP.size();

        for(int i=0;i<n;i++){
            if(listP.get(i)!=listQ.get(i)){
                return listP.get(i-1);
            }
        }

        return listP.get(n - 1);
    }

    public boolean inorder(TreeNode node, TreeNode ele, List<TreeNode> list){
        if(node==null){
            return false;
        }

        list.add(node);
        if(node.equals(ele)){
            return true;
        }

        if(inorder(node.left,ele,list)||inorder(node.right,ele,list)){
            return true;
        }

        list.remove(list.size()-1);
        return false;
    }
}