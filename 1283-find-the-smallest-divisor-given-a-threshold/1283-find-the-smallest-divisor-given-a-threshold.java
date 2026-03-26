class Solution {
    private int max(int a[]){
        int res=0;
        for(int k:a){
            res=Math.max(res,k);
        }
        return res;
    }
    private long sum(int a[],int div){
        long res=0;
        for(int i=0;i<a.length;i++){
            res=res+(int)Math.ceil((double)a[i]/div);
        }
        return res;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int mx=max(nums);
        int f=1;
        int l=mx;
        int res=Integer.MAX_VALUE;
        while(f<=l){
            int mid=f+(l-f)/2;
            long temp=sum(nums,mid);
            if(temp>threshold){
                f=mid+1;
            }else if(temp<=threshold){
                res=Math.min(res,mid);
                l=mid-1;
            }
        }
        return res;
    }
}