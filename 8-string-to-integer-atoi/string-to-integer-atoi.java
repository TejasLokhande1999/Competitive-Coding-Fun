class Solution {
    public int myAtoi(String s) {
        
        if(s.isEmpty()){
            return 0;
        }
        s=s.trim();

        if(s.isEmpty()){
            return 0;
        }
        int sign = 1;
        int index=0;
        if(s.charAt(0)=='-'){
            sign = -1;
            index=1;
        }else if(s.charAt(0)=='+'){
            index=1;
        }


        long ans=0;


        for(int i=index;i<s.length();i++){

            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                int digit = ch-'0';
                ans = ans*10 + digit;

                if (sign == 1 && ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            }else{
                break;
            }

        }

        if(sign==-1){
            ans = ans*-1;        
                return (int)ans;
        }else{
            
                return (int)ans;
            
        }


    }
}