class info{
    int i;
    int j;
    int wt;
    public info(int i,int j,int wt)
    {
        this.i=i;
        this.j=j;
        this.wt=wt;
    }
}
class Solution {
    public int minimumObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        PriorityQueue<info> pq=new PriorityQueue<>((x,y)->x.wt-y.wt);
        int a[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(a[i],Integer.MAX_VALUE);
        }
        pq.add(new info(0,0,0));
        a[0][0]=0;
        while(pq.size()!=0)
        {
            info i=pq.remove();
            int row=i.i;
            int col=i.j;
            int wt=i.wt;
            if(wt>a[row][col])
            {
                continue;
            }
            if(row==m-1&&col==n-1)
            {
                return wt;
            }
            int nrow=row+1;
            int ncol=col;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n)
            {
                int newwt=wt+grid[nrow][ncol];
                if(newwt<a[nrow][ncol])
                {
                    a[nrow][ncol]=newwt;
                    pq.add(new info(nrow,ncol,a[nrow][ncol]));
                }
            }
            nrow=row-1;
            ncol=col;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n)
            {
                int newwt=wt+grid[nrow][ncol];
                if(newwt<a[nrow][ncol])
                {
                    a[nrow][ncol]=newwt;
                    pq.add(new info(nrow,ncol,a[nrow][ncol]));
                }
            }
            nrow=row;
            ncol=col+1;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n)
            {
                int newwt=wt+grid[nrow][ncol];
                if(newwt<a[nrow][ncol])
                {
                    a[nrow][ncol]=newwt;
                    pq.add(new info(nrow,ncol,a[nrow][ncol]));
                }
            }
            nrow=row;
            ncol=col-1;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n)
            {
                int newwt=wt+grid[nrow][ncol];
                if(newwt<a[nrow][ncol])
                {
                    a[nrow][ncol]=newwt;
                    pq.add(new info(nrow,ncol,a[nrow][ncol]));
                }
            }
        }
        return a[grid.length-1][grid[0].length-1];
    }
}