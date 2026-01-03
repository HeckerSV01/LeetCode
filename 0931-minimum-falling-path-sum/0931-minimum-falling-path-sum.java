class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<n;i++)
        {
            dp[0][i]=matrix[0][i];
        }
        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int m1=matrix[i][j]+dp[i-1][j];
                int m2=0;
                if(j-1<0)
                {
                    m2=10000000;
                }
                else
                {
                    m2=matrix[i][j]+dp[i-1][j-1];
                }
                int m3=0;
                if(j+1>n-1)
                {
                    m3=10000000;
                }
                else
                {
                    m3=matrix[i][j]+dp[i-1][j+1];
                }
                dp[i][j]=Math.min(m1,Math.min(m2,m3));
            }
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            res=Math.min(res,dp[m-1][i]);
        }
        return res;
    }
}