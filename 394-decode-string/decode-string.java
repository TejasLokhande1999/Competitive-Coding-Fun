class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> charStack = new Stack<>();

        if(s.equals(""))
            return "";

        int num = 0;
        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if(ch == '[') {
                numStack.add(num);
                charStack.push("[");
                num = 0;
            } else if(ch == ']') {
                StringBuilder temp = new StringBuilder();

                while(!charStack.isEmpty() && !charStack.peek().equals("[")) {
                    temp.append(charStack.pop());
                }

                charStack.pop(); // remove '['
                int count = numStack.pop();

                StringBuilder finalStr = new StringBuilder();
                for(int i = 0; i < count; i++) {
                    finalStr.append(temp);
                }
                charStack.push(finalStr.toString());
            } else {
                charStack.push(String.valueOf(ch));
            }
        }

        StringBuilder retStr = new StringBuilder();
        while(!charStack.isEmpty()) {
            retStr.append(charStack.pop());
        }

        return retStr.reverse().toString(); // ✅ FIXED
    }
}
