class Solution {
    final int mod=1000000007;
    private int cal(int n,int i,int prev1,int prev2,int prev3,int dp[][][][]){
        if(i==n){
            return 1;
        }
        if(dp[i][prev1][prev2][prev3]!=-1){
            return dp[i][prev1][prev2][prev3];
        }
        int res=0;
        for(int j=1;j<=3;j++){
            if(j!=prev1){
                for(int k=1;k<=3;k++){
                    if(k!=prev2&&k!=j){
                        for(int l=1;l<=3;l++){
                            if(l!=prev3&&l!=k){
                                res=(res+cal(n,i+1,j,k,l,dp))%mod;
                            }
                        }
                    }
                }
            }
        }
        return dp[i][prev1][prev2][prev3]=res;
    }
    public int numOfWays(int n) {
        int dp[][][][]=new int[n][4][4][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    for(int l=0;l<4;l++){
                        dp[i][j][k][l]=-1;
                    }
                }
            }
        }
        return cal(n,0,0,0,0,dp)%mod;
    }
}