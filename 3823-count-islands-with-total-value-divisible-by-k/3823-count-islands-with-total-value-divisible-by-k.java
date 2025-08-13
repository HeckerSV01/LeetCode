class Solution {
    int sum=0;
    public void dfs(int i,int j,int vis[][],int a[][],int m,int n)
    {
        vis[i][j]=1;
        sum=sum+a[i][j];
        int row=0;
        int col=0;
        row=i-1;
        col=j;
        if(row>=0&&row<m&&col>=0&&col<n&&vis[row][col]==0&&a[row][col]!=0)
        {
            dfs(row,col,vis,a,m,n);
        }
        row=i+1;
        col=j;
        if(row>=0&&row<m&&col>=0&&col<n&&vis[row][col]==0&&a[row][col]!=0)
        {
            dfs(row,col,vis,a,m,n);
        }
        row=i;
        col=j-1;
        if(row>=0&&row<m&&col>=0&&col<n&&vis[row][col]==0&&a[row][col]!=0)
        {
            dfs(row,col,vis,a,m,n);
        }
        row=i;
        col=j+1;
        if(row>=0&&row<m&&col>=0&&col<n&&vis[row][col]==0&&a[row][col]!=0)
        {
            dfs(row,col,vis,a,m,n);
        }
    }
    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        int res=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]!=0&&vis[i][j]==0)
                {
                    sum=0;
                    dfs(i,j,vis,grid,m,n);
                    if(sum%k==0)
                    {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}