class Solution {
    public void dfs(int a[][],int vis[][],int i,int j,int m,int n)
    {
        int h=a[i][j];
        if(vis[i][j]==0)
        {
            vis[i][j]=1;
        }
        int row=0;
        int col=0;
        row=i-1;
        col=j;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]>=h&&vis[row][col]==0)
        {
            dfs(a,vis,row,col,m,n);
        }
        row=i+1;
        col=j;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]>=h&&vis[row][col]==0)
        {
            dfs(a,vis,row,col,m,n);
        }
        row=i;
        col=j-1;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]>=h&&vis[row][col]==0)
        {
            dfs(a,vis,row,col,m,n);
        }
        row=i;
        col=j+1;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]>=h&&vis[row][col]==0)
        {
            dfs(a,vis,row,col,m,n);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int pac[][]=new int[m][n];
        int at[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            if(pac[i][0]==0)
            {
                dfs(heights,pac,i,0,m,n);
            }
            if(at[i][n-1]==0)
            {
                dfs(heights,at,i,n-1,m,n);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(pac[0][i]==0)
            {
                dfs(heights,pac,0,i,m,n);
            }
            if(at[m-1][i]==0)
            {
                dfs(heights,at,m-1,i,m,n);
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(pac[i][j]==1&&at[i][j]==1)
                {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
}