class NumberContainers {
HashMap<Integer,Integer> idx;
HashMap<Integer,TreeSet<Integer>> map;
    public NumberContainers() {
        idx=new HashMap<>();
        map=new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(idx.containsKey(index))
        {
            int prev=idx.get(index);
            map.get(prev).remove(index);
            if(map.get(prev).isEmpty()) 
            { 
                map.remove(prev);
            }
        }
        idx.put(index,number);
        if(!map.containsKey(number))
        {
            map.put(number,new TreeSet<>());
        }
        map.get(number).add(index);
    }
    
    public int find(int number) {
        if(!map.containsKey(number)){
            return -1;
        }
        else
        {
            return map.get(number).first();
        }
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */