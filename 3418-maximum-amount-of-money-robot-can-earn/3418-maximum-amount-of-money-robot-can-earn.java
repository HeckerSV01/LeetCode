class Solution {
    private int solve(int a[][],int i,int j,int neut,Integer dp[][][]){
        if(i==a.length||j==a[0].length){
            return Integer.MIN_VALUE;
        }
        if(i==a.length-1&&j==a[0].length-1){
            if(a[i][j]<0&&neut>0){
                return dp[i][j][neut]=0;
            }else{
                return dp[i][j][neut]=a[i][j];
            }
        }
        if(dp[i][j][neut]!=null){
            return dp[i][j][neut];
        }
        int way1=Integer.MIN_VALUE;
        int way2=Integer.MIN_VALUE;
        int way3=Integer.MIN_VALUE;
        int way4=Integer.MIN_VALUE;
        int down1=solve(a,i+1,j,neut,dp);
        if(down1!=Integer.MIN_VALUE){
            way1=a[i][j]+down1;
        }
        int down2=solve(a,i,j+1,neut,dp);
        if(down2!=Integer.MIN_VALUE){
            way2=a[i][j]+down2;
        }
        if(a[i][j]<0&&neut>0){
            int down3=solve(a,i+1,j,neut-1,dp);
            if(down3!=Integer.MIN_VALUE){
                way3=0+down3;
            }
            int down4=solve(a,i,j+1,neut-1,dp);
            if(down4!=Integer.MIN_VALUE){
                way4=0+down4;
            }
        }
        return dp[i][j][neut]=Math.max(way1,Math.max(way2,Math.max(way3,way4)));
    }
    public int maximumAmount(int[][] coins) {
        Integer dp[][][]=new Integer[coins.length][coins[0].length][3];
        return solve(coins,0,0,2,dp);
    }
}