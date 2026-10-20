class SegTree{

    HashMap<Integer,Integer> seg;
    HashMap<Integer,Integer> lazy;

    public SegTree(){
        seg=new HashMap<>();
        lazy=new HashMap<>();
    }

    public void lazyupdate(int i){
        int val=lazy.getOrDefault(i,0);
        if(val==0){
            return;
        }
        seg.put(i,seg.getOrDefault(i,0)+val);
        lazy.put(2*i+1,lazy.getOrDefault(2*i+1,0)+val);
        lazy.put(2*i+2,lazy.getOrDefault(2*i+2,0)+val);
        lazy.remove(i);
    }

    public int rangequery(int l,int r,int low,int high,int i){
        lazyupdate(i);
        if(high<l||low>r){
            return 0;
        }else if(low>=l&&high<=r){
            return seg.getOrDefault(i,0);
        }else{
            int mid=(low+high)/2;
            int left=rangequery(l,r,low,mid,2*i+1);
            int right=rangequery(l,r,mid+1,high,2*i+2);
            return Math.max(left,right);
        }
    }

    public void update(int l,int r,int low,int high,int i){
        lazyupdate(i);
        if(high<l||low>r){
            return;
        }
        if (low >= l && high <= r) {
            lazy.put(i,lazy.getOrDefault(i,0)+1);
            lazyupdate(i);
            return;
        }
        int mid = low + (high - low) / 2;
        update(l, r, low, mid, 2 * i + 1);
        update(l, r, mid + 1, high, 2 * i + 2);
        seg.put(i, Math.max(seg.getOrDefault(2 * i + 1, 0),seg.getOrDefault(2 * i + 2, 0)));
    }
}

class MyCalendarTwo {
    SegTree st;
    public MyCalendarTwo() {
        st=new SegTree();
    }
    
    public boolean book(int startTime, int endTime) {
        if(st.rangequery(startTime,endTime-1,0,1000000000,0)>=2){
            return false;
        }
        st.update(startTime,endTime-1,0,1000000000,0);
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */