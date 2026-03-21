class Solution {
    private int solve(int i,int n,int a[],int dp[]){
        if(i>n){
            return 1000000000;
        }
        if(i==n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int onestep=1000000000;
        int twostep=1000000000;
        int threestep=1000000000;
        if(i+1<=n){
            onestep=a[i]+1+solve(i+1,n,a,dp);
        }
        if(i+2<=n){
        twostep=a[i+1]+4+solve(i+2,n,a,dp);
        }
        if(i+3<=n){
        threestep=a[i+2]+9+solve(i+3,n,a,dp);
        }
        return dp[i]=Math.min(onestep,Math.min(twostep,threestep));
    }
    public int climbStairs(int n, int[] costs) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,n,costs,dp);
    }
}