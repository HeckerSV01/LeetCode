class CustomStack {
ArrayList<Integer> stack;
int size;
    public CustomStack(int maxSize) {
        size=maxSize;
        stack=new ArrayList<>(size);
    }
    
    public void push(int x) {
        if(stack.size()==size)
        {
            return;
        }
        stack.add(x);
    }
    
    public int pop() {
        if(stack.size()==0)
        {
            return -1;
        }
        return stack.remove(stack.size()-1);
    }
    
    public void increment(int k, int val) {
        int limit=Math.min(k,stack.size());
        for(int i=0;i<limit;i++)
        {
            stack.set(i,stack.get(i)+val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */