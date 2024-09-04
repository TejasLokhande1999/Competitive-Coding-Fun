class RandomizedSet {

    ArrayList<Integer> list;
    Map<Integer, Integer> map;
    public RandomizedSet() {
        list =new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{            
            list.add(val);
            map.put(val,list.size()-1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }else{

            //else map has the value
            int eleIndex = map.get(val);
            int lastIndex = list.size()-1;

            if(eleIndex!=lastIndex){
            //move last indexed value over here
            int lastValue = list.get(lastIndex);
            list.set(eleIndex,lastValue);

            //update the index of last value with this one
            //int lastValue = list.get(lastIndex);
            map.put(lastValue, eleIndex);
            }


            list.remove(list.size()-1);
            map.remove(val);
            return true;

        }
    }
    
    public int getRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());

        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */