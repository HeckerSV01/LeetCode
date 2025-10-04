class FrontMiddleBackQueue {
Deque<Integer> left;
Deque<Integer> right;
    public FrontMiddleBackQueue() {
        left=new ArrayDeque<>();
        right=new ArrayDeque<>();
    }
    public void balance()
    {
        if(left.size()>right.size()+1)
        {
            right.addFirst(left.removeLast());
        }
        else if(left.size()<right.size())
        {
            left.addLast(right.removeFirst());
        }
    }
    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }
    
    public void pushMiddle(int val) {
        if(left.size()>right.size())
        {
            right.addFirst(left.removeLast());
        }
        left.addLast(val);
        balance();
    }
    
    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }
    
    public int popFront() {
        if(left.isEmpty()&&right.isEmpty())
        {
            return -1;
        }
        int k=left.removeFirst();
        balance();
        return k;
    }
    
    public int popMiddle() {
        if(left.isEmpty()&&right.isEmpty())
        {
            return -1;
        }
        int k=left.removeLast();
        balance();
        return k;
    }
    
    public int popBack() {
        if(left.isEmpty()&&right.isEmpty())
        {
            return -1;
        }
        int k=-1;
        if(!right.isEmpty())
        {
            k=right.removeLast();
        }
        else
        {
            k=left.removeLast();
        }
        balance();
        return k;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */