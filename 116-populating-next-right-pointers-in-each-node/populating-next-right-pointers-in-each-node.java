/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }

        Queue<Node> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int level = q.size();
            List<Node> subList = new ArrayList<>();
            for(int i=0;i<level;i++){

                Node node = q.poll();
                subList.add(node);

                if(node.left!=null){
                    q.add(node.left);
                }

                if(node.right!=null){
                    q.add(node.right);
                }
            }

            generateRight(subList);

        }

        return root;
    }

    public void generateRight(List<Node> list){

        if(list.size()==1){
            Node node = list.get(0);
            node.next=null;
            return;
        }else{

                int n = list.size();

                for(int i=0;i<n-1;i++){
                    Node first = list.get(i);
                    Node second = list.get(i+1);

                    first.next = second;
                }

                list.get(n-1).next = null; 

        }

    }
}