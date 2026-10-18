class SegTree{

    int seg[];
    int a[];

    public SegTree(int n,int a[]){
        seg=new int[4*n];
        this.a=a;
    }

    public void build(int i,int low,int high){
        if(low==high){
            seg[i]=a[low];
            return;
        }
        int mid=(high+low)/2;
        build(2*i+1,low,mid);
        build(2*i+2,mid+1,high);
        seg[i]=seg[2*i+1]+seg[2*i+2];
    }

    public int rangequery(int l,int r,int low,int high,int i){
        if(high<l||low>r){
            return 0;
        }else if(low>=l&&high<=r){
            return seg[i];
        }else{
            int mid=(low+high)/2;
            int left=rangequery(l,r,low,mid,2*i+1);
            int right=rangequery(l,r,mid+1,high,2*i+2);
            return left+right;
        }
    }
}
class NumArray {
    SegTree st;
    int nums[];
    public NumArray(int[] nums) {
        st=new SegTree(nums.length,nums);
        st.build(0,0,nums.length-1);
        this.nums=nums;
    }
    
    public int sumRange(int left, int right) {
        return st.rangequery(left,right,0,nums.length-1,0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */