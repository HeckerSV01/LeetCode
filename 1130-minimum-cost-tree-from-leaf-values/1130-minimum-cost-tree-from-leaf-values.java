class Solution {
    private int max(int a[],int i,int j){
        int res=0;
        for(int k=i;k<=j;k++){
            res=Math.max(res,a[k]);
        }
        return res;
    }
    private int solve(int a[],int i,int j,int dp[][]){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int res=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int sum=max(a,i,k)*max(a,k+1,j)+solve(a,i,k,dp)+solve(a,k+1,j,dp);
            res=Math.min(res,sum);
        }
        return dp[i][j]=res;
    }
    public int mctFromLeafValues(int[] arr) {
        int dp[][]=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                dp[i][j]=-1;
            }
        }
        return solve(arr,0,arr.length-1,dp);
    }
}