class Solution {
    private int cal(int dp[][],int a[][],int i,int j)
    {
        if(i<0||j<0)
        {
            return 0;
        }
        if(i>=0&&j>=0&&a[i][j]==1)
        {
            return 0;
        }
        if(i==0&&j==0)
        {
            return 1;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int up=cal(dp,a,i-1,j);
        int left=cal(dp,a,i,j-1);
        return dp[i][j]=up+left;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int dp[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        return cal(dp,grid,grid.length-1,grid[0].length-1);
    }
}