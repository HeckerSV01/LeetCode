class Solution {
    public void dfs(int i,int j,int vis[][],int a[][],int m,int n)
    {
        vis[i][j]=1;
        int row=0;
        int col=0;
        row=i-1;
        col=j;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]==0&&vis[row][col]==0)
        {
            dfs(row,col,vis,a,m,n);
        }
        row=i+1;
        col=j;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]==0&&vis[row][col]==0)
        {
            dfs(row,col,vis,a,m,n);
        }
        row=i;
        col=j-1;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]==0&&vis[row][col]==0)
        {
            dfs(row,col,vis,a,m,n);
        }
        row=i;
        col=j+1;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]==0&&vis[row][col]==0)
        {
            dfs(row,col,vis,a,m,n);
        }
    }
    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        for(int i=0;i<n;i++)
        {
            if(grid[0][i]==0&&vis[0][i]==0)
            {
                grid[0][i]=1;
                dfs(0,i,vis,grid,m,n);
            }
            if(grid[m-1][i]==0&&vis[m-1][i]==0)
            {
                grid[m-1][i]=1;
                dfs(m-1,i,vis,grid,m,n);
            }
        }
        for(int i=0;i<m;i++)
        {
            if(grid[i][0]==0&&vis[i][0]==0)
            {
                vis[i][0]=1;
                dfs(i,0,vis,grid,m,n);
            }
            if(grid[i][n-1]==0&&vis[i][n-1]==0)
            {
                vis[i][n-1]=1;
                dfs(i,n-1,vis,grid,m,n);
            }
        }
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(vis[i][j]==0&&grid[i][j]==0)
                {
                    count++;
                    dfs(i,j,vis,grid,m,n);
                }
            }
        }
        return count;
    }
}