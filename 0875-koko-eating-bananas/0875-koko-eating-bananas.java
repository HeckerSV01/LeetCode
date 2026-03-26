class Solution {
    private int max(int a[]){
        int res=0;
        for(int k:a){
            res=Math.max(res,k);
        }
        return res;
    }
    private long mintime(int a[],int n){
        long res=0;
        for(int k:a){
            res=res+(k + n - 1) / n;
        }
        return res;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int m=max(piles);
        int f=1;
        int l=m;
        int res=Integer.MAX_VALUE;
        while(f<=l){
            int mid=f+(l-f)/2;
            long temp=mintime(piles,mid);
            if(temp>h){
                f=mid+1;
            }else if(temp<=h){
                res=Math.min(res,mid);
                l=mid-1;
            }
        }
        return res;
    }
}