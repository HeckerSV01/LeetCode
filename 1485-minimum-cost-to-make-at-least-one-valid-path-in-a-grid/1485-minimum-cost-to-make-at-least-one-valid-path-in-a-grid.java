class pair{
    int i;
    int j;
    int cost;
    public pair(int cost,int i,int j)
    {
        this.cost=cost;
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int costs[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                costs[i][j]=Integer.MAX_VALUE;
            }
        }
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->a.cost-b.cost);
        q.add(new pair(0,0,0));
        costs[0][0]=0;
        while(!q.isEmpty())
        {
            pair p=q.remove();
            int row=p.i;
            int col=p.j;
            int cost=p.cost;
            if(row==m-1&&col==n-1)
            {
                return cost;
            }
            if(cost>costs[row][col])
            {
                continue;
            }
            int dir=grid[row][col];
            int nrow=-1;
            int ncol=-1;
            if(dir==1)
            {
                nrow=row;
                ncol=col+1;
            }
            if(dir==2)
            {
                nrow=row;
                ncol=col-1;
            }
            if(dir==3)
            {
                nrow=row+1;
                ncol=col;
            }
            if(dir==4)
            {
                nrow=row-1;
                ncol=col;
            }
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n)
            {
                if(cost<costs[nrow][ncol])
                {
                    costs[nrow][ncol]=cost;
                    q.add(new pair(cost,nrow,ncol));
                }
            }
            int direc[][]={{0,1},{0,-1},{1,0},{-1,0}};
            for(int i=0;i<4;i++)
            {
                if(row+direc[i][0]==nrow&&col+direc[i][1]==ncol)
                {
                    continue;
                }
                int r=row+direc[i][0];
                int c=col+direc[i][1];
                if(r>=0&&r<m&&c>=0&&c<n)
                {
                    if(cost+1<costs[r][c])
                    {
                        costs[r][c]=cost+1;
                        q.add(new pair(cost+1,r,c));
                    }
                }
            }
        }
        return -1;
    }
}