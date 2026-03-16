class Solution {
    private int solve(int n,int dp[]){
        if(n==1){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int sum=0;
        int max=0;
        for(int i=1;i<n;i++){
            sum=i*(n-i)+solve(i,dp)+solve(n-i,dp);
        }
        max=Math.max(max,sum);
        return dp[n]=max;
    }
    public int minCost(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
}