class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();

        for(char ch : num.toCharArray()){
            
            while(!s.isEmpty() && k>0 && s.peek()>ch){
                s.pop();
                k--;
            }
            s.push(ch);
        }

        //if k>0
        while(k>0){
            s.pop();
            k--;
        }

        Collections.reverse(s);
        StringBuilder str = new StringBuilder();
        while(!s.isEmpty()){
            str.append(s.pop());
        }

    if(str.length()==0){
        return "0";
    }

        while(str.length()>0 && str.charAt(0)=='0'){
            str.deleteCharAt(0);
        }

        return str.length() == 0 ? "0" : str.toString();
    
    }
}