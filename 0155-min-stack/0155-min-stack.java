class MinStack {
    Stack<Integer> main;
    Stack<Integer> min;
    int m;
    public MinStack() {
        this.main = new Stack<>();
        this.min = new Stack<>();
        this.m = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        main.push(val);
        m = Math.min(m, val);
        min.push(m);
    }
    
    public void pop() {
        main.pop();
        min.pop();
        m = min.isEmpty()? Integer.MAX_VALUE: min.peek();
    }
    
    public int top() {
       return main.peek();
    }
    
    public int getMin() {
        return min.peek();
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