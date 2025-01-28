class LRUCache {

    int size;
    Map<Integer, Node> map;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            Node node = map.get(key);

            if(node.prev!=head){
                remove(node);
                addFirst(node);
            }
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        
        if(!map.containsKey(key)){
            Node node = new Node(key,value);
            map.put(key,node);

            addFirst(node);

            if(map.size()>size){
                // get rid of leastRU
                map.remove(tail.prev.key);
                remove(tail.prev);
                                
            }
        }else{

            Node node = map.get(key);
            node.val = value;
            if(node.prev!=head){
            remove(node);
            addFirst(node);
            }
        }
    }

    public void remove(Node node){

        node.next.prev = node.prev;
        node.prev.next = node.next;
        return;
    }

    public void addFirst(Node node){

        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;

        return;

    }
}
class Node{

    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val){
        this.key = key;
        this.val = val;
    }


}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */