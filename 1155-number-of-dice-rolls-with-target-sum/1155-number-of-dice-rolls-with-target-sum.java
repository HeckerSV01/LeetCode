class Solution {
    final int mod=1000000007;
    private int solve(int i,int n,int k,int target,int dp[][]){
        if(i==n&&target==0){
            return 1;
        }
        if(target<0){
            return 0;
        }
        if(i==n&&target>0){
            return 0;
        }
        if(dp[i][target]!=-1){
            return dp[i][target];
        }
        int way=0;
        for(int j=1;j<=k;j++){
            way=(way+solve(i+1,n,k,target-j,dp))%mod;
        }
        return dp[i][target]=way%mod;
    }
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][]=new int[n+1][target+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=target;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,n,k,target,dp);
    }
}