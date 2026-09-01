class Solution {
    public long power(long x,long y,long MOD){
        long res=1;
        while(y>0){
            if(y%2==1){
                res=(res*x)%MOD;
            }
            x=(x*x)%MOD;
            y=y/2;
        }
        return res;
    }
    public int sumDecoded(long[] nums) {
        final long MOD=1000000007L;
        long res=0;
        for(int i=0;i<nums.length;i++){
            long width=nums[i]%10;
            long d=(long)Math.floor(nums[i]/10);
            long temp=d;
            int dig=0;
            while(temp!=0){
                dig++;
                temp=temp/10;
            }
            long k=(long)Math.pow(10,dig-width);
            long x=d/k;
            long y=d%k;
            long l=power(x,y,MOD);
            res=(res+l)%MOD;
        }
        return (int)res;
    }
}