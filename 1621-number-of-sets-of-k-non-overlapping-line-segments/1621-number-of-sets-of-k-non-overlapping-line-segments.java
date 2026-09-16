class Solution {
    final int MOD=1000000007;
    private int solve(int n,int i,int k,int insegment,Integer dp[][][]){
        if(k==0){
            return 1;
        }
        if(i>=n){
            return 0;
        }
        if(dp[i][k][insegment]!=null){
            return dp[i][k][insegment];
        }
        long res=0;
        if(insegment==1){
            res=(res+solve(n,i+1,k,1,dp))%MOD;
            res=(res+solve(n,i,k-1,0,dp))%MOD;
        }else{
            res=(res+solve(n,i+1,k,1,dp))%MOD;
            res=(res+solve(n,i+1,k,0,dp))%MOD;
        }
        return dp[i][k][insegment]=(int)res;
    }
    public int numberOfSets(int n, int k) {
        Integer dp[][][]=new Integer[n+1][k+1][2];
        return solve(n,0,k,0,dp);
    }
}