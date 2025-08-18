class idx{
    int i;
    int j;
    int dis;
    public idx(int i,int j,int dis)
    {
        this.i=i;
        this.j=j;
        this.dis=dis;
    }
}
class Solution {
    public int maxDistance(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        Queue<idx> q=new LinkedList<>();
        int res=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1&&vis[i][j]==0)
                {
                    q.add(new idx(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        if(q.isEmpty()||q.size()==m*n)
        {
            return -1;
        }
        while(!q.isEmpty())
        {
            idx curr=q.remove();
            int row=curr.i;
            int col=curr.j;
            int dis=curr.dis;
            res=Math.max(res,dis);
            int nrow=0;
            int ncol=0;
            nrow=row-1;
            ncol=col;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&vis[nrow][ncol]==0&&grid[nrow][ncol]==0)
            {
                q.add(new idx(nrow,ncol,dis+1));
                vis[nrow][ncol]=1;
            }
            nrow=row+1;
            ncol=col;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&vis[nrow][ncol]==0&&grid[nrow][ncol]==0)
            {
                q.add(new idx(nrow,ncol,dis+1));
                vis[nrow][ncol]=1;
            }
            nrow=row;
            ncol=col-1;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&vis[nrow][ncol]==0&&grid[nrow][ncol]==0)
            {
                q.add(new idx(nrow,ncol,dis+1));
                vis[nrow][ncol]=1;
            }
            nrow=row;
            ncol=col+1;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&vis[nrow][ncol]==0&&grid[nrow][ncol]==0)
            {
                q.add(new idx(nrow,ncol,dis+1));
                vis[nrow][ncol]=1;
            }
        }
        return res;
    }
}