class TimeMap {

    HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        ArrayList<Pair> list = map.getOrDefault(key, new ArrayList<>());

        list.add(new Pair(value,timestamp));

        map.put(key,list);
        //map.put(key, map.getOrDefault(key, new ArrayList<>()).add(new Pair(value, timestamp)));

    }
    
    public String get(String key, int timestamp) {
        ArrayList<Pair> list = new ArrayList<>();

        list = map.get(key);
        if(list==null){
            return "";
        }
        //Collections.sort(list, new PairComparator());

        return binSearch(list,timestamp);
    }

    public String binSearch(ArrayList<Pair> list, int ele){
        int start = 0;
        int end = list.size()-1;
        String str="";
        while(start<=end){
            int mid = start+ (end-start)/2;

            Pair p = list.get(mid);
            if(p.timestamp==ele){
                return p.value;
            }else if(p.timestamp<ele){
                str = list.get(start).value;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return str;
    }
}

class Pair{

    int timestamp;
    String value;

    Pair(String value, int timestamp){
        this.timestamp = timestamp;
        this.value = value;
    }
}

class PairComparator implements Comparator<Pair>{

    public int compare(Pair p1, Pair p2){
        if(p1.timestamp>p2.timestamp){
            return 1;
        }else if(p1.timestamp<p2.timestamp){
            return -1;
        }else{
            return 0;
        }
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */