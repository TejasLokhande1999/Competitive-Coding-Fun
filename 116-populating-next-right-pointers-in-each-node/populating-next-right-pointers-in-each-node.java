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
        List<List<Node>> list = new ArrayList<>();
        Queue<Node> q= new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Node> tempList = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node node = q.poll();

                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                tempList.add(node);
            }
            list.add(tempList);
        }


        for(List<Node> l : list){

            int n = l.size();
            for(int i=0;i<n;i++){

                Node node = l.get(i);
                if(i<n-1){
                    node.next = l.get(i+1);
                }else{
                    node.next=null;
                }
            }
        }

        return root;
    }
}