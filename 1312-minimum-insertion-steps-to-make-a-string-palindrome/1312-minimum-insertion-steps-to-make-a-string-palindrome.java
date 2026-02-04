class Solution {
    public int lcs(String s1,String s2,int i1,int i2,int dp[][]) {
        if(i1<0||i2<0){
            return 0;
        }
        if(dp[i1][i2]!=-1){
            return dp[i1][i2];
        }
        if(s1.charAt(i1)==s2.charAt(i2)){
            return 1+lcs(s1,s2,i1-1,i2-1,dp);
        }
        return dp[i1][i2]=Math.max(lcs(s1,s2,i1-1,i2,dp),lcs(s1,s2,i1,i2-1,dp));
    }

    public int minInsertions(String s) {
        int dp[][]=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                dp[i][j]=-1;
            }
        }
        return s.length() - lcs(s, new StringBuilder(s).reverse().toString(),s.length()-1,s.length()-1,dp);
    }
}