class SmallestInfiniteSet {
HashSet<Integer> set;
int min;
    public SmallestInfiniteSet() {
        set=new HashSet<>();
        min=1;
    }
    
    public int popSmallest() {
        set.add(min);
        int k=min;
        for(int i=min+1;;i++)
        {
            if(!set.contains(i))
            {
                min=i;
                break;
            }
        }
        return k;
    }
    
    public void addBack(int num) {
        set.remove(num);
        if(num<min)
        {
            min=num;
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */