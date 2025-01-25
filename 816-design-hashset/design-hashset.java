class MyHashSet {

    List<Integer> map[];
    public MyHashSet() {
        map = new ArrayList[1000];
        for(int i=0;i<1000;i++){
            map[i] = new ArrayList<>();
        }
    }
    
    public void add(int key) {
        int bucket = key%1000;
        List<Integer> list = map[bucket];
        for(Integer i: list){
            if(i==key){
                return;
            }
        }

        list.add(key);
    }
    
    public void remove(int key) {
         int bucket = key%1000;
        List<Integer> list = map[bucket];
        for(Integer i: list){
            if(i==key){
                list.remove(Integer.valueOf(key));
                return;
            }
        }

    }
    
    public boolean contains(int key) {
        int bucket = key%1000;
        List<Integer> list = map[bucket];
        for(Integer i: list){
            if(i==key){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */