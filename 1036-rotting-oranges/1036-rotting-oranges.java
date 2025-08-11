class variabl{
        int i;
        int j;
        int time;
        public variabl(int i,int j,int time)
        {
            this.i=i;
            this.j=j;
            this.time=time;
        }
    }
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<variabl> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new variabl(i,j,0));
                    vis[i][j]=2;
                }
            }
        }
        int res=0;
        while(!q.isEmpty())
        {
            variabl curr=q.remove();
            int row=curr.i;
            int col=curr.j;
            int t=curr.time;
            res=Math.max(res,t);
            int nrow=0;
            int ncol=0;
            nrow=row-1;
            ncol=col;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&vis[nrow][ncol]==0&&grid[nrow][ncol]==1)
            {
                q.add(new variabl(nrow,ncol,t+1));
                vis[nrow][ncol]=2;
            }
            nrow=row+1;
            ncol=col;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&vis[nrow][ncol]==0&&grid[nrow][ncol]==1)
            {
                q.add(new variabl(nrow,ncol,t+1));
                vis[nrow][ncol]=2;
            }
            nrow=row;
            ncol=col-1;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&vis[nrow][ncol]==0&&grid[nrow][ncol]==1)
            {
                q.add(new variabl(nrow,ncol,t+1));
                vis[nrow][ncol]=2;
            }
            nrow=row;
            ncol=col+1;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&vis[nrow][ncol]==0&&grid[nrow][ncol]==1)
            {
                q.add(new variabl(nrow,ncol,t+1));
                vis[nrow][ncol]=2;
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(vis[i][j]!=2&&grid[i][j]==1)
                {
                    return -1;
                }
            }
        }
        return res;
    }
}