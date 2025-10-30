class Solution {
    public int[] calculate(int a[][],int m,int n)
    {
        int r1=0;
        int r2=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=m-1,j=n-1;i>=0&&j>=0;--i,--j)
        {
            set.add(a[i][j]);
        }
        r1=set.size();
        set.clear();
        for(int i=m+1,j=n+1;i<a.length&&j<a[0].length;++i,++j)
        {
            set.add(a[i][j]);
        }
        r2=set.size();
        return new int[]{r1,r2};
    }
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int res[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int k[]=calculate(grid,i,j);
                res[i][j]=Math.abs(k[0]-k[1]);
            }
        }
        return res;
    }
}