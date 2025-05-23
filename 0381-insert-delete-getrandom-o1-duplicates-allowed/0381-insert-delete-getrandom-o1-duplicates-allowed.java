class RandomizedCollection {
    ArrayList<Integer> list;
    HashMap<Integer,Integer> map;
    public RandomizedCollection() {
        list=new ArrayList<>();
        map=new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val))
        {
            list.add(val);
            map.put(val,1);
            return true;
        }
        list.add(val);
        map.put(val,map.get(val)+1);
        return false;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
        {
            return false;
        }
        if(map.get(val)==1)
        {
            list.remove(list.indexOf(val));
            map.remove(val);
            return true;
        }
        list.remove(list.lastIndexOf(val));
        map.put(val,map.get(val)-1);
        return true;
    }
    
    public int getRandom() {
        Random r=new Random();
        return list.get(r.nextInt(list.size())); 
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */