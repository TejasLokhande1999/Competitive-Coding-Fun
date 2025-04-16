class AllOne {

    Map<String, Integer> map;
    TreeSet<Pair> set;
    public AllOne() {
        map = new HashMap<>();
        set = new TreeSet<>((a,b)->{
            if(a.freq!=b.freq)
                return a.freq-b.freq;
            return a.str.compareTo(b.str);
        });
    }
    
    public void inc(String key) {
        int n = map.getOrDefault(key,0);
        map.put(key, map.getOrDefault(key,0)+1);
        
        if(n!=0)
            set.remove(new Pair(n,key));

        set.add(new Pair(n+1,key));

    }
    
    public void dec(String key) {
        
        int n = map.getOrDefault(key,0);
        set.remove(new Pair(n,key));

        if(n==1){
            map.remove(key);
            return;
        }

        map.put(key,n-1);
        set.add(new Pair(n-1,key));

    }
    
    public String getMaxKey() {
        if(set.isEmpty())
            return "";
        return set.last().str;
    }
    
    public String getMinKey() {
        if(set.isEmpty())
            return "";
        return set.first().str;
    }
}


class Pair{

    int freq;
    String str;
    Pair(int freq, String str){
        this.freq = freq;
        this.str = str;
    }

}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */