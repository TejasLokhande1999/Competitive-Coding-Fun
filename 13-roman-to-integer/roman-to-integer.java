class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);


        int n = s.length(); 
        int res=0;   
        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            int currVal = map.get(curr);

            if(i!=n-1){
                char next = s.charAt(i+1);
                int nextVal = map.get(next);
                if(nextVal>currVal){
                    res =res + (nextVal-currVal);
                    i+=1;
                }else{
                    res+=currVal;
                }

            }else{          //i at last index
                res+=currVal;
            }
        }

        return res;
    }
}
