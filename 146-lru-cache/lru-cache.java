class LRUCache {

    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    public void deleteNode(Node node){
        map.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public void addFirst(Node node){
        map.put(node.key,node);
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }


    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            int val = node.val;
            deleteNode(node);
            Node newNode = new Node(key,val);
            addFirst(newNode);
            return val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            Node newNode = new Node(key,value);
            addFirst(newNode);
        }else{
            Node node = new Node(key,value);
            map.put(key,node);
            addFirst(node);

            if(map.size()>capacity){
                deleteNode(tail.prev);
            }

        }
    }
}
class Node{

    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }


}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */