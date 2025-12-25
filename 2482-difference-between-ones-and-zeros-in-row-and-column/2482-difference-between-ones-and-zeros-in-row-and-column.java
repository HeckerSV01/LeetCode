class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int zr[]=new int[m];
        int zc[]=new int[n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    zr[i]++;
                    zc[j]++;
                }
            }
        }
        int res[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                res[i][j]=(n-zr[i])+(m-zc[j])-zr[i]-zc[j];
            }
        }
        return res;
    }
}