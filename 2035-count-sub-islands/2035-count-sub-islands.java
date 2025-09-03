class Solution {
    public boolean dfs(int g1[][],int g2[][],int vis[][],int i,int j,int m,int n)
    {
        if(g2[i][j]==1&&g1[i][j]!=1)
        {
            return false;
        }
        vis[i][j]=1;
        boolean check=true;
        int d[][]={{0,1},{1,0},{0,-1},{-1,0}};
        for(int k=0;k<4;k++)
        {
            int row=i+d[k][0];
            int col=j+d[k][1];
            if(row>=0&&row<m&&col>=0&&col<n&&g2[row][col]==1&&vis[row][col]==0)
            {
                if(!dfs(g1,g2,vis,row,col,m,n))
                {
                    check=false;
                }
            }
        }
        return check;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m=grid2.length;
        int n=grid2[0].length;
        int count=0;
        int vis[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid2[i][j]==1&&vis[i][j]==0)
                {
                    if(dfs(grid1,grid2,vis,i,j,m,n))
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}