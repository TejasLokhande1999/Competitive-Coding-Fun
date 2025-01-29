class Solution {
    public boolean checkValidString(String s) {
        
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);

            if(ch=='('){
                leftStack.add(i);
            }else if(ch=='*'){
                starStack.add(i);
            }else{

                //ch ==')';

                if(!leftStack.isEmpty()){
                    leftStack.pop();
                }else if(!starStack.isEmpty()){
                    starStack.pop();
                }else{
                    return false;
                }

            }

        }

        while(!leftStack.isEmpty() && !starStack.isEmpty()){
            if(leftStack.peek()<starStack.peek()){
                leftStack.pop();
                starStack.pop();
            }else{
                return false;
            }
        }

        if(!leftStack.isEmpty())
            return false;

        return true;
    }
}