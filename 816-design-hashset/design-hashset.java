class MyHashSet {
    boolean arr[];
    public MyHashSet() {
        arr = new boolean[10000001];
    }
    
    public void add(int key) {
        if(arr[key]==false){
            arr[key]=true;
        }
    }
    
    public void remove(int key) {
        if(arr[key]==true){
            arr[key]=false;
        }
    }
    
    public boolean contains(int key) {
        if(arr[key]==true){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */