
// * Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 

 class Pair {
    private TreeNode node;
    private int depth;

    Pair(TreeNode node, int depth){
        this.node=node;
        this.depth=depth;
    }

    public int getDepth(){
        return depth;
    }

    public TreeNode getNode(){
        return node;
    }


 }
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
    
        if(depth==1){
            TreeNode newNode = new TreeNode(val);
            newNode.left=root;
            return newNode;
        }else{

            Queue<Pair> q = new LinkedList<Pair>();
            ArrayList<Pair> list = new ArrayList<Pair>();
            list.add(new Pair(root,1));
            q.add(new Pair(root,1));

            while(!q.isEmpty()){

                Pair pair = q.poll();
                TreeNode node = pair.getNode();

                if(node.left!=null){
                    q.add(new Pair(node.left, pair.getDepth()+1));
                    list.add(new Pair(node.left, pair.getDepth()+1));
                }
                if(node.right!=null){
                    q.add(new Pair(node.right, pair.getDepth()+1));
                    list.add(new Pair(node.right, pair.getDepth()+1));
                }

            }

        //Now get the nodes with the depth=depth-1
        int counter=0;

         ArrayList<Pair> finalList = new ArrayList<Pair>();

        for(int i=0;i<list.size();i++){
            if(list.get(i).getDepth()==depth-1)
                finalList.add(list.get(i));
            System.out.print(list.get(i).getNode().val+":"+list.get(i).getDepth()+"   | ");
               
        }

         for(int i=0;i<finalList.size();i++){
            Pair pair = finalList.get(i);
            TreeNode curr = pair.getNode();
            
            // Create new nodes that will be the new left and right children of 'curr'
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);

            // Connect new nodes to the existing children of 'curr'
            newLeft.left = curr.left;   // Attach existing left child to new left node
            newRight.right = curr.right; // Attach existing right child to new right node

            // Set new nodes as children of 'curr'
            curr.left = newLeft;
            curr.right = newRight;

        }

            return root;

        }


    }
}