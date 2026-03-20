class Solution {
    final int mod=1000000007;
    private int solve(int n,int picked,int delivered,int dp[][]){
        if(delivered==n){
            return 1;
        }
        if(dp[picked][delivered]!=-1){
            return dp[picked][delivered];
        }
        long ways=0;
        if(picked<n){
            ways=(ways+(long)(n-picked)*solve(n,picked+1,delivered,dp))%mod;
        }
        if(delivered<picked){
            ways=(ways+(long)(picked-delivered)*solve(n,picked,delivered+1,dp))%mod;
        }
        return dp[picked][delivered]=(int)ways%mod;
    }
    public int countOrders(int n) {
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(n,0,0,dp);
    }
}