class Solution {
    public int[] findmax(int a[][],int i,int j)
    {
        int maxr=a[i][j];
        int maxc=a[i][j];
        for(int m=0;m<a.length;m++)
        {
            if(a[i][m]>maxr)
            {
                maxr=a[i][m];
            }
            if(a[m][j]>maxc)
            {
                maxc=a[m][j];
            }
        }
        int res[]=new int[2];
        res[0]=maxr;
        res[1]=maxc;
        return res;
    }
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int max[]=new int[2];
        int res=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
                max=findmax(grid,i,j);
                res=res+Math.min(max[0],max[1])-grid[i][j];
            }
        }
        return res;
    }
}