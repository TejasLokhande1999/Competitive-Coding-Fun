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
            int val1 = map.get(ch);
            if(i>0){
                char ch2 = s.charAt(i-1);
                int val2 = map.get(ch2);

                if(val2<val1){
                    sum-=val2;
                    sum+=val1-val2;
                }else{
                    sum+=val1;
                }
            }else{
                sum+=val1;
            }
        }

    return sum;

    }
}