class variable{
    int i;
    int j;
    int dis;
    public variable(int i,int j,int dis)
    {
        this.i=i;
        this.j=j;
        this.dis=dis;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int res[][]=new int[mat.length][mat[0].length];
        int vis[][]=new int[mat.length][mat[0].length];
        Queue<variable> q=new LinkedList<>();
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new variable(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        while(!q.isEmpty())
        {
            variable v=q.remove();
            int row=v.i;
            int col=v.j;
            int dis=v.dis;
            res[row][col]=dis;
            int nrow=0;
            int ncol=0;
            nrow=row-1;
            ncol=col;
            if(nrow>=0&&nrow<mat.length&&ncol>=0&&ncol<mat[0].length&&vis[nrow][ncol]==0)
            {
                q.add(new variable(nrow,ncol,dis+1));
                vis[nrow][ncol]=1;
            }
            nrow=row+1;
            ncol=col;
            if(nrow>=0&&nrow<mat.length&&ncol>=0&&ncol<mat[0].length&&vis[nrow][ncol]==0)
            {
                q.add(new variable(nrow,ncol,dis+1));
                vis[nrow][ncol]=1;
            }
            nrow=row;
            ncol=col-1;
            if(nrow>=0&&nrow<mat.length&&ncol>=0&&ncol<mat[0].length&&vis[nrow][ncol]==0)
            {
                q.add(new variable(nrow,ncol,dis+1));
                vis[nrow][ncol]=1;
            }
            nrow=row;
            ncol=col+1;
            if(nrow>=0&&nrow<mat.length&&ncol>=0&&ncol<mat[0].length&&vis[nrow][ncol]==0)
            {
                q.add(new variable(nrow,ncol,dis+1));
                vis[nrow][ncol]=1;
            }
        }
        return res;
    }
}