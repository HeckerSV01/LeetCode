class SegTree{

    HashMap<Integer,Integer> seg[];
    int a[];
    int n;

    public SegTree(int n,int a[]){
        this.n=a.length;
        seg=new HashMap[n*4];
        this.a=a;
    }

    public void build(int i,int low,int high){
        seg[i]=new HashMap<>();
        if(low==high){
            seg[i].put(a[low],1);
            return;
        }
        int mid=(high+low)/2;
        build(2*i+1,low,mid);
        build(2*i+2,mid+1,high);
        for(int k:seg[2*i+1].keySet()){
            seg[i].put(k,seg[2*i+1].get(k));
        }
        for(int k:seg[2*i+2].keySet()){
            seg[i].put(k,seg[i].getOrDefault(k,0)+seg[2*i+2].get(k));
        }
    }

    public int rangequery(int l,int r,int low,int high,int i,int val){
        if(high<l||low>r){
            return 0;
        }else if(low>=l&&high<=r){
            return seg[i].getOrDefault(val,0);
        }else{
            int mid=(low+high)/2;
            int left=rangequery(l,r,low,mid,2*i+1,val);
            int right=rangequery(l,r,mid+1,high,2*i+2,val);
            return left+right;
        }
    }
}

class RangeFreqQuery {
    SegTree st;
    int n;
    public RangeFreqQuery(int[] arr) {
        st=new SegTree(arr.length,arr);
        st.build(0,0,arr.length-1);
        n=arr.length;
    }
    
    public int query(int left, int right, int value) {
        return st.rangequery(left,right,0,n-1,0,value);
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */