class MyHashSet {
    List<List<Integer>> list;
    public MyHashSet() {
        list = new ArrayList<>();
        for(int i=0;i<10;i++)
            list.add(new ArrayList<>());
    }
    
    public void add(int key) {
        int index = key%10;
        List<Integer> ll = list.get(index);
        if(!ll.contains(key))
            ll.add(key);
    
    }
    
    public void remove(int key) {
        int index = key%10;
        List<Integer> ll = list.get(index);
        ll.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int index = key%10;
        List<Integer> ll = list.get(index);
        if(ll.contains(key))
            return true;
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