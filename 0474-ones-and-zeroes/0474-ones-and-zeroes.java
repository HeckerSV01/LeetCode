class Solution {
    private boolean check(int count[],String s,int m,int n){
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'0']++;
        }
        if(count[0]<=m&&count[1]<=n){
            return true;
        }else{
            return false;
        }
    }
    private int cal(String a[],int m,int n,int i,int dp[][][]){
        if(i<0){
            return 0;
        }
        if(dp[m][n][i]!=-1){
            return dp[m][n][i];
        }
        int count[]=new int[2];
        int notpick=cal(a,m,n,i-1,dp);
        int pick=0;
        if(check(count,a[i],m,n)){
            pick=1+cal(a,m-count[0],n-count[1],i-1,dp);
        }
        return dp[m][n][i]=Math.max(pick,notpick);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][][]=new int[m+1][n+1][strs.length];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<strs.length;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return cal(strs,m,n,strs.length-1,dp);
    }
}