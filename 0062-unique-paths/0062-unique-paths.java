class Solution {
    private int cal(int dp[][],int i,int j)
    {
        if(i==0&&j==0)
        {
            return 1;
        }
        if(i<0||j<0)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int up=cal(dp,i-1,j);
        int left=cal(dp,i,j-1);
        return dp[i][j]=up+left;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return cal(dp,m-1,n-1);
    }
}