class Solution {
    int res=Integer.MAX_VALUE;
    private void solve(int cookies[],int i,int a[]){
        if(i==cookies.length){
            int max=Integer.MIN_VALUE;
            for(int k:a){
                max=Math.max(max,k);
            }
            res=Math.min(res,max);
            return;
        }
        for(int j=0;j<a.length;j++){
            a[j]=a[j]+cookies[i];
            solve(cookies,i+1,a);
            a[j]=a[j]-cookies[i];
        }
    }
    public int distributeCookies(int[] cookies, int k) {
        int a[]=new int[k];
        solve(cookies,0,a);
        return res;
    }
}