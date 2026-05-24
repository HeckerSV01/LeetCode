class Solution {
    private int solve(int a[],int i,int d,int dp[]){
        if(dp[i]!=-1){
            return dp[i];
        }
        int max=1;
        int n=a.length;
        for(int j=1;j<=d&&i+j<n;j++){
            if(a[i+j]<a[i]){
                max=Math.max(max,1+solve(a,i+j,d,dp));
            }else{
                break;
            }
        }
        for(int j=1;j<=d&&i-j>=0;j++){
            if(a[i-j]<a[i]){
                max=Math.max(max,1+solve(a,i-j,d,dp));
            }else{
                break;
            }
        }
        return dp[i]=max;
    }
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        int res=-1;
        int dp[]=new int[arr.length];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            res=Math.max(res,solve(arr,i,d,dp));
        }
        return res;
    }
}