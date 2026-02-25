class Solution {
    private int cal(int n,int dp[]){
        if(n<=2){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int max=0;
        for(int i=1;i<n;i++){
            int split=i*cal(n-i,dp);
            int notsplit=i*(n-i);
            max=Math.max(max,Math.max(split,notsplit));
        }
        return dp[n]=max;
    }
    public int integerBreak(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return cal(n,dp);
    }
}