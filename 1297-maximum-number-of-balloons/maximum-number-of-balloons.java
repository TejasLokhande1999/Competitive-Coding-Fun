class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : text.toCharArray()){

            if(ch=='b' || ch=='a' || ch=='l' || ch=='o' || ch=='n'){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
        }

        int min = Integer.MAX_VALUE;


        if(map.size()<5){
            return 0;
        }

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            char key = entry.getKey();
            int val = entry.getValue();
            if(key=='o'||key=='l'){
                min = Math.min(min,val/2);
            }else{
                min = Math.min(min,val);
            }
        }

        return min;

    }
}