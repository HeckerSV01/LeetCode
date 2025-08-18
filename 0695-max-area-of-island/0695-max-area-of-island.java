class Solution {
    int sum=0;
    private void dfs(int a[][],int vis[][],int i,int j,int m,int n)
    {
        vis[i][j]=1;
        sum++;
        int row=0;
        int col=0;
        row=i-1;
        col=j;
        if(row>=0&&row<m&&col>=0&&col<n&&vis[row][col]==0&&a[row][col]!=0)
        {
            dfs(a,vis,row,col,m,n);
        }
        row=i+1;
        col=j;
        if(row>=0&&row<m&&col>=0&&col<n&&vis[row][col]==0&&a[row][col]!=0)
        {
            dfs(a,vis,row,col,m,n);
        }
        row=i;
        col=j-1;
        if(row>=0&&row<m&&col>=0&&col<n&&vis[row][col]==0&&a[row][col]!=0)
        {
            dfs(a,vis,row,col,m,n);
        }
        row=i;
        col=j+1;
        if(row>=0&&row<m&&col>=0&&col<n&&vis[row][col]==0&&a[row][col]!=0)
        {
            dfs(a,vis,row,col,m,n);
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[grid.length][grid[0].length];
        int max=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(vis[i][j]==0&&grid[i][j]==1)
                {
                    dfs(grid,vis,i,j,m,n);
                    if(sum>max)
                    {
                        max=sum;
                    }
                    sum=0;
                }
            }
        }
        return max;
    }
}