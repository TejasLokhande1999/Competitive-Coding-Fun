
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
    /*
        if(depth==1){
            TreeNode newNode = new TreeNode(val);
            newNode.left=root;
            return newNode;
        }else{

            Queue<Pair> q = new LinkedList<Pair>();
            ArrayList<Pair> list = new ArrayList<Pair>();
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
        }

         for(int i=0;i<finalList.size();i++){
            Pair pair = finalList.get(i);
            TreeNode curr = pair.getNode();

            if(curr.left!=null){
                TreeNode newNode = new TreeNode(val);
                newNode.left=curr.left;
                curr.left=newNode;
                newNode.right=null;
            }else if(curr.right!=null){
                TreeNode newNode = new TreeNode(val);
                newNode.right=curr.right;
                curr.right=newNode;
                newNode.left=null;
            }

        }

            return root;

        }
*/

          if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.getNode();
            int currentDepth = pair.getDepth();

            // Check if the next level is the desired depth - 1
            if (currentDepth == depth - 1) {
                // Insert new nodes
                TreeNode tempLeft = node.left; // save existing left child
                TreeNode tempRight = node.right; // save existing right child

                node.left = new TreeNode(val); // create new left node
                node.right = new TreeNode(val); // create new right node

                node.left.left = tempLeft; // connect saved left child to new left node
                node.right.right = tempRight; // connect saved right child to new right node
            } else {
                // Enqueue children to process at the next level
                if (node.left != null) {
                    queue.add(new Pair(node.left, currentDepth + 1));
                }
                if (node.right != null) {
                    queue.add(new Pair(node.right, currentDepth + 1));
                }
            }
        }

        return root;
    }
}