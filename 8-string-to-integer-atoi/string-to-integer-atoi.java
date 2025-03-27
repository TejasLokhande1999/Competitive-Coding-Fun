class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int sign = 1;
        int index=0;
        int n = s.length();
        if(s.isEmpty()){
            return 0;
        }
        if(s.charAt(0)=='-'){
            sign = -1;
            index=1;
        }else if(s.charAt(0)=='+'){
            sign = 1;
            index=1;
        }

        long num=0;
        

        for(int i=index;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10 + ch-'0';
            
                if(sign==-1 && -num<Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }else if(sign==1 && num>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }else{
                break;
            }

        }

        return (int)num*sign;
    }
}