class TimeMap {

    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        List<Pair> list = map.get(key);
        if(list==null){
            return "";
        }
        if(list.get(0).time>timestamp){
            return "";
        }else{

            String str = binarySearchFloor(list,timestamp);
            return str;
        }
    }

    public String binarySearchFloor(List<Pair> list, int timestamp){

        int left = 0;
        int right = list.size()-1;
        String str = "";
        while(left<=right){
            int mid = right+(left-right)/2;

            Pair p = list.get(mid);

            if(p.time<timestamp){
                left = mid+1;
                str = p.value;
            }else if(p.time>timestamp){
                right = mid-1;
            }else{
                str = p.value;
                break;
            }
        }

        return str;

    }
}
class Pair{

    String value;
    int time;

    Pair(String value, int time){
        this.value = value;
        this.time = time;
    }

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */