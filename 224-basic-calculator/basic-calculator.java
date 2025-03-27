class Solution {

    int index = 0;
    public int calculate(String s) {
        return calc(s);
    }

    public int calc(String s){

        int res=0;
        int num =0;
        int sign = 1;

        while(index<s.length()){

            char ch = s.charAt(index++);
            
            //building the number (If multiple characters)
            if(Character.isDigit(ch)){
                num = num*10 + ch-'0';
            }else if(ch=='+'){

                //get the result
                res = res+num*sign;
                sign=1;
                num=0;
            }else if(ch=='-'){
                res = res+num*sign;
                sign = -1;
                num=0;
            }else if(ch=='('){
                num = calc(s);
            }else if(ch==')'){
                res = res+num*sign;
                return res;
            }
        }

        return res+num*sign;

    }
}