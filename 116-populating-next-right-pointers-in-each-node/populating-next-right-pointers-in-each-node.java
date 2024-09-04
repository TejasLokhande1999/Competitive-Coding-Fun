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

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root,0));

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                Pair p = q.poll();
                Node front = p.node;
                int level = p.level;
                if(q.size()==0){
                    front.next=null;
                }else if(level==q.peek().level){
                    front.next=q.peek().node;
                }else{
                    front.next=null;
                }
                if(front.left!=null){
                    q.add(new Pair(front.left,level+1));
                }
                if(front.right!=null){
                    q.add(new Pair(front.right,level+1));
                }

            } 
        }

        return root; 
    }
}
class Pair{
    Node node;
    int level;
    Pair(Node node, int level){
        this.node = node;
        this.level = level;
    }
}