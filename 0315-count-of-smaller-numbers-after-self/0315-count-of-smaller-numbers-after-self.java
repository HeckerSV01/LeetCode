class SegTree{

    int seg[];

    public SegTree(){
        seg=new int[4*20001];
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

    public void update(int idx,int low,int high,int i){
        if(low==high){
            seg[i]++;
            return;
        }
        int mid=(low+high)/2;
        if(idx<=mid){
            update(idx,low,mid,2*i+1);
        }
        else {
            update(idx,mid+1,high,2*i+2);
        }
        seg[i]=seg[2*i+1]+seg[2*i+2];
    }
}
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        SegTree st=new SegTree();
        List<Integer> res=new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            res.add(st.rangequery(0,nums[i]-1+10000,0,20000,0));
            st.update(nums[i]+10000,0,20000,0);
        }
        return res.reversed();
    }
}