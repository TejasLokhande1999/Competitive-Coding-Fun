class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int value = map.get(ch);

            if(i>0){
                char chPrev = s.charAt(i-1);
                int valuePrev = map.get(chPrev);

                if(value>valuePrev){
                    sum-=valuePrev;
                    sum+=value-valuePrev;
                }else{
                    sum+=value;
                }
            }else{
                sum+=value;
            }

        }
        return sum;
    }
}