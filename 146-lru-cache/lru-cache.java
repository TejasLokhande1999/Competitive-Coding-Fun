class LRUCache {

    int k;
    Map<Integer, Integer> map;
    ArrayList<Integer> list;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.k =capacity;
        list =new ArrayList<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){

            list.remove((Integer) key);
            list.add(key);
            return map.get(key);
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            list.remove((Integer) key);
            list.add(key);
        }else{
            //does not contain key
            if(map.size()<k){       //nornally insert
                map.put(key,value);
                list.add(key);
            }else{
                //
                map.remove(list.get(0));
                map.put(key,value);
                list.remove(0);
                list.add(key);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */