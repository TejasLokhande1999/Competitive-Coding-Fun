class Solution {
    public int longestValidParentheses(String s) {
        
        int open = 0;
        int close = 0;

        int maxLen = 0;
        int globalMax = 0;

        for(char ch : s.toCharArray()){

            if(ch=='('){
                open++;
            }else{
                close++;
            }

            if(close>open){
                    close=0;
                    open=0;                 
            }else if(close==open){
                    maxLen = open*2;
                    globalMax = Math.max(globalMax,maxLen);
            }

        }

        int n = s.length();
        int maxLen2=0;
        close=0;
        open=0;
        for(int i =n-1;i>=0;i--){
            char ch = s.charAt(i);

            if(ch==')'){
                close++;
            }else{  
                open++;
            }

            if(open>close){
                    open=0;
                    close=0;
            }else if(open==close){
                    maxLen2 = open*2;
                    globalMax = Math.max(globalMax, maxLen2);
            }
        }

        return globalMax;
    }
}