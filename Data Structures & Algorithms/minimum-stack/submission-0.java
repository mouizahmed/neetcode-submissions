class MinStack {

    private Stack<Map.Entry<Integer, Integer>> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) stack.push(Map.entry(val, val));
        else {
            Integer min = stack.peek().getValue();
            if ((min != null) && val > min) stack.push(Map.entry(val, min));
            else stack.push(Map.entry(val, val));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().getKey();
    }
    
    public int getMin() {
        return stack.peek().getValue();
    }
}
