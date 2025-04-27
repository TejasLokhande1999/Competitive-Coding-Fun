class Solution {
    public String minRemoveToMakeValid(String s) {

    StringBuilder retStr = new StringBuilder();
    Stack<Pair> stack = new Stack<>();

    int n = s.length();

    for(int i=0;i<n;i++){

        char ch = s.charAt(i);

        if(ch=='('){
            stack.push(new Pair(ch,i));
        }else if(ch==')'){
            if(stack.isEmpty()){
                stack.push(new Pair(ch,i));
            }else{

                if(stack.peek().ch=='('){
                    stack.pop();
                }else{
                    stack.push(new Pair(ch,i));
                }
            }
        }

    }


    //we get the () which needs to be elimintes;

    for(int i=n-1;i>=0;i--){
        char ch = s.charAt(i);

        if(ch!='(' && ch!=')'){
            retStr.append(ch);
        }else{

            if(ch=='('){
                if(!stack.isEmpty() && stack.peek().ch=='(' && stack.peek().index==i)
                {
                    stack.pop();
                }
                else
                    retStr.append(ch);
            }else if(ch==')'){
                if(!stack.isEmpty() && stack.peek().ch==')' && stack.peek().index==i){
                    stack.pop();
                }
                else
                    retStr.append(ch);
            }

        }
    }


    return retStr.reverse().toString();


    }
}

class Pair{

    char ch;
    int index;

    Pair(char ch, int index){
        this.ch = ch;
        this.index = index;
    }
}