class pair{
    int ht;
    int i;
    int j;
    public pair(int ht,int i,int j)
    {
        this.ht=ht;
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int m=grid.length;
        PriorityQueue<pair> pq=new PriorityQueue<>((x,y)->x.ht-y.ht);
        int vis[][]=new int[m][m];
        pq.add(new pair(grid[0][0],0,0));
        vis[0][0]=1;
        while(pq.size()!=0)
        {
            pair p=pq.remove();
            int ht=p.ht;
            int row=p.i;
            int col=p.j;
            if(row==m-1&&col==m-1)
            {
                return ht;
            }
            int nrow=row+1;
            int ncol=col;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0)
            {
                vis[nrow][ncol]=1;
                int hmax=Math.max(ht,grid[nrow][ncol]);
                pq.add(new pair(hmax,nrow,ncol));
            }
            nrow=row-1;
            ncol=col;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0)
            {
                vis[nrow][ncol]=1;
                int hmax=Math.max(ht,grid[nrow][ncol]);
                pq.add(new pair(hmax,nrow,ncol));
            }
            nrow=row;
            ncol=col+1;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0)
            {
                vis[nrow][ncol]=1;
                int hmax=Math.max(ht,grid[nrow][ncol]);
                pq.add(new pair(hmax,nrow,ncol));
            }
            nrow=row;
            ncol=col-1;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0)
            {
                vis[nrow][ncol]=1;
                int hmax=Math.max(ht,grid[nrow][ncol]);
                pq.add(new pair(hmax,nrow,ncol));
            }
        }
        return -1;
    }
}