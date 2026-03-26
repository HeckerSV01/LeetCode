class Solution {
    private int[] max(int a[]){
        int sum=0;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            sum=sum+a[i];
            res=Math.max(res,a[i]);
        }
        return new int[]{sum,res};
    }
    private int caldays(int a[],int n){
        int res=1;
        int wt=0;
        for(int i=0;i<a.length;i++){
            if(wt+a[i]<=n){
                wt=wt+a[i];
            }else{
                res++;
                wt=a[i];
            }
        }
        return res;
    }
    public int shipWithinDays(int[] weights, int days) {
        int k[]=max(weights);
        int f=k[1];
        int l=k[0];
        int res=Integer.MAX_VALUE;
        while(f<=l){
            int mid=f+(l-f)/2;
            int temp=caldays(weights,mid);
            if(temp>days){
                f=mid+1;
            }else if(temp<=days){
                res=Math.min(res,mid);
                l=mid-1;
            }
        }
        return res;
    }
}