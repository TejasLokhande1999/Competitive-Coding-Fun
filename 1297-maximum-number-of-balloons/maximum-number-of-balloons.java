class Solution {
    public int maxNumberOfBalloons(String text) {
        int count=0;

        String str = "balloon";

        Map<Character, Integer> map = new HashMap<>();

        for(char ch : text.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        while(true){

            for(char ch : str.toCharArray()){

                if(map.containsKey(ch)){

                    if(map.get(ch)>0){
                        map.put(ch,map.getOrDefault(ch,0)-1);
                    }else{
                        return count;
                    }
                }else{
                        return count;
                }
            }
            count++;
        }
    }
}