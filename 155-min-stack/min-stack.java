public class Pair{
    int val;
    int minEle;

    Pair(int val, int minEle){
        this.val = val;
        this.minEle = minEle;
    }

}
class MinStack {

    Stack<Pair> stack;
    int min;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {

        if(stack.isEmpty()){
            stack.push(new Pair(val,val));
        }else{
            stack.push(new Pair(val, Math.min(val,stack.peek().minEle)));
        }


    }
    
    public void pop() {
        
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().minEle;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */