class Solution {
    final int mod=1000000007;
    private int solve(int a[],int start,int finish,int fuel,int dp[][]){
        if(fuel<0){
            return 0;
        }
        if(dp[start][fuel]!=-1){
            return dp[start][fuel];
        }
        int ways=0;
        if(start==finish){
            ways=1;
        }
        for(int i=0;i<a.length;i++){
            if(i!=start){
                ways=(ways+solve(a,i,finish,fuel-Math.abs(a[start]-a[i]),dp))%mod;
            }
        }
        return dp[start][fuel]=ways;
    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int dp[][]=new int[locations.length][fuel+1];
        for(int i=0;i<locations.length;i++){
            for(int j=0;j<=fuel;j++){
                dp[i][j]=-1;
            }
        }
        return solve(locations,start,finish,fuel,dp);
    }
}