class Solution {
    public String simplifyPath(String pathTotal) {
        
        int n = pathTotal.length();

        //Stack<String> stack = new Stack<>();
        Deque<String> stack = new ArrayDeque<>();

        String[] paths = pathTotal.split("/");

        StringBuilder str = new StringBuilder();
        for(String path : paths){
            if(path.equals("..")){
                if(!stack.isEmpty()) stack.removeLast();
            }else{
                if(!path.equals("") &&!path.equals(".")) stack.addLast(path);
            }
        }

        // while(!stack.isEmpty()){
        //     str.append(stack.pop());
        //     str.append("/");
        // }

        for (String dir : stack) {
            str.append("/").append(dir);
        }
        String result = str.length() == 0 ? "/" : str.toString();

        return result;
        //return "/" + String.join("/", stack);


    }
}