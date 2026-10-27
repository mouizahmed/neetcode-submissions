class MinStack {

    long min;
    Stack<Long> stack;

    public MinStack() {
        this.stack = new Stack<>();      
    }

    /*
    initial: [] min = /
    push 1: [0] min = 1;
    push 2: [0,1] min = 1;
    push 0: [0,1,-1] min = 0
    pop: [0, 1] min = 0-(-1) = 1


    */
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val-min);
            if (val < min) min = val;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        long pop = stack.pop();
        if (pop < 0) min = min-pop;
    }
    
    public int top() {
        long top = stack.peek();
        if (top > 0) return (int) (min+top);
        else return (int) min;
        
    }
    
    public int getMin() {
        return (int) min;
    }
}
