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
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        if(grid[0][0]==1||grid[m-1][m-1]==1)
        {
            return -1;
        }
        int vis[][]=new int[m][m];
        Queue<idx> q=new LinkedList<>();
        q.add(new idx(0,0,1));
        vis[0][0]=1;
        while(!q.isEmpty())
        {
            idx curr=q.remove();
            int row=curr.i;
            int col=curr.j;
            int dis=curr.dis;
            if(row==m-1&&col==m-1)
            {
                return dis;
            }
            int nrow=0;
            int ncol=0;
            nrow=row-1;
            ncol=col;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<m&&grid[nrow][ncol]==0&&vis[nrow][ncol]==0)
            {
                q.add(new idx(nrow,ncol,dis+1));
                vis[nrow][ncol]=1;
            }
            nrow=row+1;
            ncol=col;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<m&&grid[nrow][ncol]==0&&vis[nrow][ncol]==0)
            {
                q.add(new idx(nrow,ncol,dis+1));
                vis[nrow][ncol]=1;
            }
            nrow=row;
            ncol=col-1;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<m&&grid[nrow][ncol]==0&&vis[nrow][ncol]==0)
            {
                q.add(new idx(nrow,ncol,dis+1));
                vis[nrow][ncol]=1;
            }
            nrow=row;
            ncol=col+1;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<m&&grid[nrow][ncol]==0&&vis[nrow][ncol]==0)
            {
                q.add(new idx(nrow,ncol,dis+1));
                vis[nrow][ncol]=1;
            }
            nrow=row-1;
            ncol=col-1;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<m&&grid[nrow][ncol]==0&&vis[nrow][ncol]==0)
            {
                q.add(new idx(nrow,ncol,dis+1));
                vis[nrow][ncol]=1;
            }
            nrow=row-1;
            ncol=col+1;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<m&&grid[nrow][ncol]==0&&vis[nrow][ncol]==0)
            {
                q.add(new idx(nrow,ncol,dis+1));
                vis[nrow][ncol]=1;
            }
            nrow=row+1;
            ncol=col-1;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<m&&grid[nrow][ncol]==0&&vis[nrow][ncol]==0)
            {
                q.add(new idx(nrow,ncol,dis+1));
                vis[nrow][ncol]=1;
            }
            nrow=row+1;
            ncol=col+1;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<m&&grid[nrow][ncol]==0&&vis[nrow][ncol]==0)
            {
                q.add(new idx(nrow,ncol,dis+1));
                vis[nrow][ncol]=1;
            }
        }
        return -1;
    }
}