class MyCircularDeque {
Deque<Integer> d;
int count;
int k;
    public MyCircularDeque(int k) {
        d=new ArrayDeque<>();
        count=0;
        this.k=k;
    }
    
    public boolean insertFront(int value) {
        if(count==k)
        {
            return false;
        }
        d.addFirst(value);
        count++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(count==k)
        {
            return false;
        }
        d.addLast(value);
        count++;
        return true;
    }
    
    public boolean deleteFront() {
        if(d.isEmpty())
        {
            return false;
        }
        d.removeFirst();
        count--;
        return true;
    }
    
    public boolean deleteLast() {
        if(d.isEmpty())
        {
            return false;
        }
        d.removeLast();
        count--;
        return true;
    }
    
    public int getFront() {
        if(d.isEmpty())
        {
            return -1;
        }
        return d.getFirst();
    }
    
    public int getRear() {
         if(d.isEmpty())
        {
            return -1;
        }
        return d.getLast();
    }
    
    public boolean isEmpty() {
        return count==0;
    }
    
    public boolean isFull() {
        return count==k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */