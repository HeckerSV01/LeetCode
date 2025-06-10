class FreqStack {
HashMap<Integer,Integer> f;
HashMap<Integer,Stack<Integer>> map;
int max;
    public FreqStack() {
        f=new HashMap<>();
        map=new HashMap<>();
        max=0;
    }
    
    public void push(int val) {
        f.put(val,f.getOrDefault(val,0)+1);
        int freq=f.get(val);
        max=Math.max(max,freq);
        if(!map.containsKey(freq))
        {
            map.put(freq,new Stack<Integer>());
        }
        map.get(freq).push(val);
    }
    
    public int pop() {
        int x=map.get(max).pop();
        f.put(x,max-1);
        if(map.get(max).size()==0)
        {
            max--;
        }
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */