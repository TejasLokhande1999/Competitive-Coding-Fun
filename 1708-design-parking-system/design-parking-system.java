class ParkingSystem {

    HashMap<Integer,Integer> map = new HashMap<>();
    public ParkingSystem(int big, int medium, int small) {
        map.put(1,big);
        map.put(2,medium);
        map.put(3,small);      
    }
    
    public boolean addCar(int carType) {
        int space = map.get(carType);
        if(space==0){
            return false;
        }

        map.put(carType,space-1);
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */