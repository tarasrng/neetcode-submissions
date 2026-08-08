class MinStack {

    private List<Integer> stack;
    private List<Integer> min;


    public MinStack() {
        stack = new ArrayList<>();
        min = new ArrayList<>();
    }
    
    public void push(int val) {
        if (!min.isEmpty() && min.getLast() < val) {
            min.add(min.getLast());
        } else {
            min.add(val);
        }
        stack.add(val);
    }
    
    public void pop() {
        stack.removeLast();
        min.removeLast();
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
       return min.getLast();
    }
}
