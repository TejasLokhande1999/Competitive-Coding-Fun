class LRUCache {

    // int k;
    // Map<Integer, Integer> map;
    // ArrayList<Integer> list;
    // public LRUCache(int capacity) {
    //     this.map = new HashMap<>();
    //     this.k =capacity;
    //     list =new ArrayList<>();
    // }
    
    // public int get(int key) {
    //     if(map.containsKey(key)){

    //         list.remove((Integer) key);
    //         list.add(key);
    //         return map.get(key);
    //     }else{
    //         return -1;
    //     }
    // }
    
    // public void put(int key, int value) {
    //     if(map.containsKey(key)){
    //         map.put(key,value);
    //         list.remove((Integer) key);
    //         list.add(key);
    //     }else{
    //         //does not contain key
    //         if(map.size()<k){       //nornally insert
    //             map.put(key,value);
    //             list.add(key);
    //         }else{
    //             //
    //             map.remove(list.get(0));
    //             map.put(key,value);
    //             list.remove(0);
    //             list.add(key);
    //         }
    //     }
    // }

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity=0;
    
    LRUCache(int capacity){
        this.map = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next=tail;
        this.tail.prev = head;
        this.capacity = capacity;
    }

    public void insert(Node node){
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next=node;
        node.prev = head;
    }

    public void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
        }

        if(map.size()==capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
}

class Node{

    Node next;
    Node prev;
    int key;
    int value;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */