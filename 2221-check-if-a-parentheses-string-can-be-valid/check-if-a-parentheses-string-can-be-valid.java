class Solution {
    public boolean canBeValid(String s, String locked) {
        
        int n = s.length();
        if(n%2==1){
            return false;
        }
    //     Stack<Pair> st = new Stack<>();
    //     for(int i=0;i<s.length();i++){
    //         char ch = s.charAt(i);
    //         char l = locked.charAt(i);
    //         if(ch=='('){
    //             st.push(new Pair(ch,i));
    //         }else if(ch==')'){
    //             if(!st.isEmpty()){
    //              Pair p = st.pop();
    //              char c = p.ch;
    //              int index = p.index;

    //              if(c=='('){
    //                 continue;
    //              }else if(c==')' && locked.charAt(index)=='0'){
    //                 continue;
    //             }else{
    //                 return false;
    //             }
    //         }
    //     }


    // }
    //         return true;



              // First pass: Left to Right check
        int openBalance = 0; // To track the number of '(' or unlocked '*'
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || locked.charAt(i) == '0') {
                openBalance++;
            } else {
                openBalance--;
            }

            // If at any point, we have more closing ')' than possible opening '('
            if (openBalance < 0) {
                return false;
            }
        }

        // Second pass: Right to Left check
        int closeBalance = 0; // To track the number of ')' or unlocked '*'
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ')' || locked.charAt(i) == '0') {
                closeBalance++;
            } else {
                closeBalance--;
            }

            // If at any point, we have more opening '(' than possible closing ')'
            if (closeBalance < 0) {
                return false;
            }
        }

        // If both passes are valid, the string can be valid.
        return true;

}
}
class Pair{
    char ch;
    int index;
    Pair(char ch, int index){
        this.ch = ch;
        this.index=index;
    }
}