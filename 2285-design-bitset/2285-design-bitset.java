class Bitset {
HashSet<Integer> zero;
HashSet<Integer> one;
int n;
    public Bitset(int size) {
        n=size;
        zero=new HashSet<>();
        one=new HashSet<>();
        for(int i=0;i<size;i++)
        {
            zero.add(i);
        }
    }
    
    public void fix(int idx) {
        zero.remove(idx);
        one.add(idx);
    }
    
    public void unfix(int idx) {
        one.remove(idx);
        zero.add(idx);
    }
    
    public void flip() {
        HashSet<Integer> temp=one;
        one=zero;
        zero=temp;
    }
    
    public boolean all() {
        if(one.size()==n)
        {
            return true;
        }
        return false;
    }
    
    public boolean one() {
        if(one.size()>0)
        {
            return true;
        }
        return false;
    }
    
    public int count() {
        return one.size();
    }
    
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(zero.contains(i))
            {
                sb.append("0");
            }
            else
            {
                sb.append("1");
            }
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */