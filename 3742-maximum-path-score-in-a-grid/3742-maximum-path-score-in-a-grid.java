class Solution {
    private int solve(int a[][],int i,int j,int k,Integer dp[][][]){
        int m=a.length-1;
        int n=a[0].length-1;
        if(i>m||j>n){
            return -1000000;
        }
        int cost=(a[i][j]==1||a[i][j]==2)?1:0;
        int rem=k-cost;
        if(rem<0){
            return -1000000;
        }
        if(i==m&&j==n){
            return a[m][n];
        }
        if(dp[i][j][k]!=null){
            return dp[i][j][k];
        }
        int right=a[i][j]+solve(a,i,j+1,rem,dp);
        int down=a[i][j]+solve(a,i+1,j,rem,dp);
        return dp[i][j][k]=Math.max(right,down);
    }
    public int maxPathScore(int[][] grid, int k) {
        Integer dp[][][]=new Integer[grid.length][grid[0].length][k+1];
        int res=solve(grid,0,0,k,dp);
        return (res<0)?-1:res;
    }
}