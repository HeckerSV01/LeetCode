class Solution {
    public int divide(int dividend, int divisor){
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        int res=0;
        long n=Math.abs((long)dividend);
        long d=Math.abs((long)divisor);
        while(n>=d){
            long k=d;
            int count=1;
            while((k<<1)<=n){
                k=k<<1;
                count=count<<1;
            }
            n=n-k;
            res=res+count;
        }
        if((dividend<0&&divisor>0)||(dividend>0&&divisor<0)){
            return -(res);
        }
        return res;
    }
}