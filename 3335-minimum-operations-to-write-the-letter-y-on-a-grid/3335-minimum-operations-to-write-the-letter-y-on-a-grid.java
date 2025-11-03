class Solution {
    public boolean isony(int i,int j,int n)
    {
        int center=n/2;
        return (i==j&&i<=center)||(j==center&&i>=center)||(i+j==n-1&&i<=center);
    }
    public int minimumOperationsToWriteY(int[][] grid) {
        int n=grid.length;
        int freqy[]=new int[3];
        int freqnoty[]=new int[3];
        int ysize=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isony(i,j,n))
                {
                    freqy[grid[i][j]]++;
                    ysize++;

                }
                else
                {
                    freqnoty[grid[i][j]]++;
                }
            }
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(i==j)
                {
                    continue;
                }
                int k=ysize-freqy[i]+((n*n-ysize)-freqnoty[j]);
                res=Math.min(res,k);
            }
        }
        return res;
    }
}