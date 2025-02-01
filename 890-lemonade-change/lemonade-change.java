class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5,0);
        map.put(10,0);
        map.put(20,0);

        for(int i=0;i<bills.length;i++){
            int dollar = bills[i];

            int diff = dollar-5;

            if(diff==0){
                map.put(5, map.getOrDefault(5,0)+1);
            }else if(diff==5){

                if(map.get(5)>=1){
                    map.put(5, map.getOrDefault(5,0)-1);
                    map.put(10, map.getOrDefault(10,0)+1);

                }else{
                    return false;
                }
            }else if(diff==15){

                if(map.get(10)>=1){
                    map.put(10, map.getOrDefault(10,0)-1);
                    if(map.get(5)>=1){
                    map.put(5, map.getOrDefault(5,0)-1);
                }else{
                    return false;
                }

                }else{
                    if(map.get(5)>=3){
                    map.put(5, map.getOrDefault(5,0)-3);
                }else{
                    return false;
                }
                }

            }
        }

        return true;
    }
}