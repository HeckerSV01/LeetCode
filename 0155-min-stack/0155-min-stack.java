class MinStack {
Stack<Integer> s;
ArrayList<Integer> min;
    public MinStack() {
        s=new Stack<>();
        min=new ArrayList<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(min.size()==0||val<=min.get(min.size()-1))
        {
            min.add(val);
        }
    }
    
    public void pop() {
        int k=s.pop();
        if(k==min.get(min.size()-1))
        {
            min.remove(min.size()-1);
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min.get(min.size()-1);
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