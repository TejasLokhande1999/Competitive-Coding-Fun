class LRUCache {

    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer,Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            int val = map.get(key).val;
            Node node = map.get(key);
            deleteNode(node);
            Node newNode = new Node(key,val);
            addFirst(newNode);
            return val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        Node newNode = new Node(key,value);
        if(!map.containsKey(key)){
            if(map.size()>=capacity){
                deleteNode(tail.prev);
            }
                addFirst(newNode);
                //map.put(key, newNode);
            
        }else{
            Node node = map.get(key);
            deleteNode(node);
            addFirst(newNode);
            //map.put(key,newNode);
            
        }
    }

    public void addFirst(Node newNode){
        map.put(newNode.key,newNode);
        newNode.next = head.next;
        newNode.next.prev = newNode;
        newNode.prev = head;
        head.next = newNode;
    }

    public void deleteNode(Node node){
        map.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}

class Node{

    Node next;
    Node prev;
    

    int key;
    int val;

    Node(int key , int val){
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