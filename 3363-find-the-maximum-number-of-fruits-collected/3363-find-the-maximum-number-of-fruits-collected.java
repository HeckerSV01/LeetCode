class Solution {
    private int solve1(int a[][],int i,int j,int dp[][]){
        if(i<0||j<0||i>=a.length||j>=a.length){
            return 0;
        }
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(j==i+1){
            return a[i][j]+solve1(a,i+1,j+1,dp);
        }
        int way1=a[i][j]+solve1(a,i+1,j-1,dp);
        int way2=a[i][j]+solve1(a,i+1,j+1,dp);
        int way3=a[i][j]+solve1(a,i+1,j,dp);
        return dp[i][j]=Math.max(way1,Math.max(way2,way3));
    }
    private int solve2(int a[][],int i,int j,int dp[][]){
        if(i<0||j<0||i>=a.length||j>=a.length){
            return 0;
        }
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(j==i-1){
            return a[i][j]+solve2(a,i+1,j+1,dp);
        }
        int way1=a[i][j]+solve2(a,i-1,j+1,dp);
        int way2=a[i][j]+solve2(a,i,j+1,dp);
        int way3=a[i][j]+solve2(a,i+1,j+1,dp);
        return dp[i][j]=Math.max(way1,Math.max(way2,way3));
    }
    public int maxCollectedFruits(int[][] fruits) {
        int dp1[][]=new int[fruits.length][fruits.length];
        int dp2[][]=new int[fruits.length][fruits.length];
        for(int i=0;i<fruits.length;i++){
            for(int j=0;j<fruits.length;j++){
                dp1[i][j]=-1;
                dp2[i][j]=-1;
            }
        }
        int res=0;
        for(int i=0;i<fruits.length;i++){
            res=res+fruits[i][i];
        }
        return res+solve1(fruits,0,fruits.length-1,dp1)+solve2(fruits,fruits.length-1,0,dp2);
    }
}