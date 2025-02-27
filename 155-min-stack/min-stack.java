class MinStack {

    Stack<Pair> s;
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push(new Pair(val,val));
        }else{
            int prevVal = s.peek().min;
            s.push(new Pair(val,Math.min(val,prevVal)));
        }
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().ele;
    }
    
    public int getMin() {
        return s.peek().min;
    }
}

class Pair{

    int ele;
    int min;
    Pair(int ele, int min){
        this.ele = ele;
        this.min = min;
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