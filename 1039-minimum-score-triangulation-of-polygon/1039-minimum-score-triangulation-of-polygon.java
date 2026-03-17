class Solution {
    private int solve(int a[],int i,int j,int dp[][]){
        if(i+1==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int sum=a[i]*a[k]*a[j]+solve(a,i,k,dp)+solve(a,k,j,dp);
            min=Math.min(min,sum);
        }
        return dp[i][j]=min;
    }
    public int minScoreTriangulation(int[] values) {
        int dp[][]=new int[values.length][values.length];
        for(int i=0;i<values.length;i++){
            for(int j=0;j<values.length;j++){
                dp[i][j]=-1;
            }
        }
        return solve(values,0,values.length-1,dp);
    }
}