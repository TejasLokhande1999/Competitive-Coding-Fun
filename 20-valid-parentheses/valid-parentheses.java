class Solution {
    public boolean isValid(String str) {
        
        Stack<Character> s = new Stack<>();

        char ch=' ';
        char check=' ';
        for(int i=0;i<str.length();i++){
            ch = str.charAt(i);

            if(ch=='{' || ch=='[' || ch=='('){
                s.push(ch);
            }

            else if(ch=='}'){
                if(s.isEmpty())
                    return false;
                check = s.pop();
                if(check=='{'){
                    continue;
                }else{
                    return false;
                }
            }
            else if(ch==']'){
                if(s.isEmpty())
                    return false;
                check = s.pop();
                if(check=='['){
                    continue;
                }else{
                    return false;
                }
            }
            else if(ch==')'){
                if(s.isEmpty())
                    return false;
                check = s.pop();
                if(check=='('){
                    continue;
                }else{
                    return false;
                }
            }

        }

        if(s.isEmpty())
            return true;

        return false;


    }
}