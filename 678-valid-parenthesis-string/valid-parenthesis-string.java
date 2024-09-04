class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> bracket = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch=='('){
                bracket.push(i);
            }else if(ch=='*'){
                star.push(i);
            }else if(ch==')'){
                if(!bracket.isEmpty()){
                    bracket.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }
            }
        }

       // ****CCC
        //CCC*****

        while(!bracket.isEmpty()&&!star.isEmpty()){
            if(bracket.peek()<star.peek()){
                bracket.pop();
                star.pop();
            }else{
                return false;
            }
        }

        if(!bracket.isEmpty()){
            return false;
        }

        return true;

    }
}