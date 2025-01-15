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
class BSTIterator {
    ArrayList<Integer> list = new ArrayList<>();
    int pointer;
    public BSTIterator(TreeNode root) {
        inorder(root,list);
        pointer = -1;
    }
    
    public int next() {
        if(pointer==-1){
            pointer=0;
            return list.get(pointer);
        }
        pointer+=1;
        return list.get(pointer);
    }
    
    public boolean hasNext() {
        if(pointer<list.size()-1)
            return true;
        return false;
    }

    public void inorder(TreeNode node,ArrayList<Integer> list){
        if(node==null){
            return;
        }
        if(node.left!=null){
            inorder(node.left,list);
        }
        list.add(node.val);
        if(node.right!=null){
            inorder(node.right,list);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */