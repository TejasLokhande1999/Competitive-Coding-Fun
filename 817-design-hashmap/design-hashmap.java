class MyHashMap {

    LinkedList<Entry> map[];

    public MyHashMap() {
        map = new LinkedList[1000];
        for(int i=0;i<1000;i++){
            map[i] = new LinkedList<>();
        }
    }
    
    public void put(int key, int value) {
        int bucket = key%1000;
        LinkedList<Entry> entries = map[bucket];

        for(Entry entry :entries){
            if(entry.key==key){
                entry.value=value;
                return;
            }
        }

        entries.add(new Entry(key,value));
    }
    
    public int get(int key) {
        int bucket = key%1000;
        LinkedList<Entry> entries = map[bucket];

        for(Entry entry : entries){
            if(entry.key==key){
                return entry.value;
            }
        }

        return -1;

    }
    
    public void remove(int key) {
        int bucket = key%1000;
        LinkedList<Entry> entries = map[bucket];

        for(Entry entry : entries){
            if(entry.key==key){
                entries.remove(entry);
                return;
            }
        }

        return;
    }
}

public class Entry{

    int key;
    int value;

    public Entry(int key, int value){
        this.key = key;
        this.value = value;
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */