class Solution {
    private int cal(String s,int i,int n,int dp[][]){
        if(n==0){
            return 1;
        }
        if(dp[i][n]!=-1){
            return dp[i][n];
        }
        int res=0;
        for(int j=i;j<s.length();j++){
            res=res+cal(s,j,n-1,dp);
        }
        return dp[i][n]=res;
    }
    public int countVowelStrings(int n) {
        String s="aeiou";
        int dp[][]=new int[s.length()][n+1];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return cal(s,0,n,dp);
    }
}