class RandomizedSet {

    List<Integer>list;
    Map<Integer, Integer>map;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{

            list.add(val);
            int index = list.size()-1;
            map.put(val,index);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){

        //     if(map.size()==1){
        //         map.remove(val);
        //         list.remove(list.size()-1);
        //         return true;
        //     }
        //     int oldIndex = map.get(val);
        //     int oldKey = val;
        //     map.remove(val);

        //     int lastKey = list.get(list.size()-1);
        //     map.put(lastKey,oldIndex);

        // //put the element at LastIndex to the element at the removed index
        // list.set(oldIndex,lastKey);
        // list.remove(list.size()-1);

          // Get the index of the element to remove
    int oldIndex = map.get(val);

    // Get the last element in the list
    int lastKey = list.get(list.size() - 1);

    // Swap the last element with the element to remove
    list.set(oldIndex, lastKey);
    map.put(lastKey, oldIndex);

    // Remove the last element from the list and the map
    list.remove(list.size() - 1);
    map.remove(val);


            return true;
        }else{
            return false;
        }
    }
    
    public int getRandom() {
        Random obj = new Random();

        int randVal = Math.abs(obj.nextInt());

        int index = randVal%list.size();
        System.out.println(randVal+" "+index);
        return list.get(index);        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */