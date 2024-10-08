class MyHashMap {

    int SIZE = 769;
    LinkedList<Entry> map[];

    public MyHashMap() {
        map = new LinkedList[SIZE];
    }
    
    public void put(int key, int val) {
        int bucket = key%SIZE;
        if(map[bucket]==null){
            map[bucket] = new LinkedList<Entry>();
            map[bucket].add(new Entry(key,val));
        }else{
            for(Entry entry : map[bucket]){
                if(entry.key==key){
                    entry.val=val;
                    return;
                }
            }

            map[bucket].add(new Entry(key,val));
        }

    }
    
    public int get(int key) {
        int bucket = key%SIZE;
        LinkedList<Entry> entries = map[bucket];
        if(entries==null){
            return -1;
        }else{
            for(Entry entry : entries){
                if(entry.key==key){
                    return entry.val;
                }
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucket = key%SIZE;

        LinkedList<Entry> list = map[bucket];
        if(list==null){
            return;
        }else{
            for(Entry entry : list){
                if(entry.key==key){
                    list.remove(entry);
                    return;
                }
            }
        }

    }
}

class Entry{
    int key;
    int val;
    Entry(int key, int val){
        this.key = key;
        this.val= val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */