class Solution {
    private int cal(String s1, String s2, int i, int j, int dp[][]){
        if(j<0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            int take=cal(s1,s2,i-1,j-1,dp);
            int nottake=cal(s1,s2,i-1,j,dp);
            return dp[i][j]=take+nottake;
        } else {
            return dp[i][j]=cal(s1,s2,i-1,j,dp);
        }
    }
    public int numDistinct(String s, String t) {
        int dp[][]=new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<t.length();j++){
                dp[i][j]=-1;
            }
        }
        return cal(s,t,s.length()-1,t.length()-1,dp);
    }
}