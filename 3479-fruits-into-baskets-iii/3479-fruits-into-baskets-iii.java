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
        seg[i]=Math.max(seg[2*i+1],seg[2*i+2]);
    }

    public int rangequery(int l,int r,int low,int high,int i){
        if(high<l||low>r){
            return Integer.MIN_VALUE;
        }else if(low>=l&&high<=r){
            return seg[i];
        }else{
            int mid=(low+high)/2;
            int left=rangequery(l,r,low,mid,2*i+1);
            int right=rangequery(l,r,mid+1,high,2*i+2);
            return Math.max(left,right);
        }
    }

    public void update(int idx,int val,int low,int high,int i){
        if(low==high){
            seg[i]=val;
            a[idx]=val;
            return;
        }
        int mid=(low+high)/2;
        if(idx<=mid){
            update(idx,val,low,mid,2*i+1);
        }
        else {
            update(idx,val,mid+1,high,2*i+2);
        }
        seg[i]=Math.max(seg[2*i+1],seg[2*i+2]);
    }
}

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        SegTree st=new SegTree(baskets.length,baskets);
        st.build(0,0,baskets.length-1);
        int res=0;
        for(int i=0;i<fruits.length;i++){
            int idx=0;
            if(st.seg[idx]<fruits[i]){
                res++;
                continue;
            }
            int low=0;
            int high=baskets.length-1;
            while(low<high){
                int mid=(low+high)/2;
                if(st.seg[idx*2+1]>=fruits[i]){
                    idx=idx*2+1;
                    high=mid;
                }else{
                    idx=idx*2+2;
                    low=mid+1;
                }
            }
            st.update(low,-1,0,baskets.length-1,0);
        }
        return res;
    }
}