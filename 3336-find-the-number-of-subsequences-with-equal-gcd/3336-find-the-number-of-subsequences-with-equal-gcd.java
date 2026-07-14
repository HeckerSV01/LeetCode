class Solution {
    final int MOD=1000000007;
    private int gcd(int a,int b){
        while(b>0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    private int solve(int a[],int gcd1,int gcd2,int i,Integer dp[][][]){
        if(i==a.length){
            if(gcd1!=0&&gcd2!=0&&gcd1==gcd2){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[gcd1][gcd2][i]!=null){
            return dp[gcd1][gcd2][i];
        }
        long skip=solve(a,gcd1,gcd2,i+1,dp);
        long takeIn1=0;
        long takeIn2=0;
        int ngcd1=0;
        int ngcd2=0;
        if(gcd1==0){
            ngcd1=a[i];
        }else{
            ngcd1=gcd(gcd1,a[i]);
        }
        takeIn1=(takeIn1+solve(a,ngcd1,gcd2,i+1,dp))%MOD;
        if(gcd2==0){
            ngcd2=a[i];
        }else{
            ngcd2=gcd(gcd2,a[i]);
        }
        takeIn2=(takeIn2+solve(a,gcd1,ngcd2,i+1,dp))%MOD;
        return dp[gcd1][gcd2][i]=(int)((skip+takeIn1+takeIn2)%MOD);
    }
    public int subsequencePairCount(int[] nums) {
        Integer dp[][][]=new Integer[201][201][nums.length];
        return solve(nums,0,0,0,dp);
    }
}