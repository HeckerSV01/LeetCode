class Solution {
    private int cal(int i,int j,int grid[][],int dp[][])
    {
        if(i==0&&j==0)
        {
            return grid[0][0];
        }
        if(i<0||j<0)
        {
            return 100000000;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int up=grid[i][j]+cal(i-1,j,grid,dp);
        int left=grid[i][j]+cal(i,j-1,grid,dp);
        return dp[i][j]=Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return cal(m-1,n-1,grid,dp);
    }
}