class info{
    int diff;
    int row;
    int col;
    public info(int diff,int row,int col)
    {
        this.diff=diff;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int effort[][]=new int[m][n];
        PriorityQueue<info> pq=new PriorityQueue<>((x,y)->x.diff-y.diff);
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                effort[i][j]=Integer.MAX_VALUE;
            }
        }
        effort[0][0]=0;
        pq.add(new info(0,0,0));
        int dr[]={-1,0,1,0};
        int dc[]={0,-1,0,1};
        while(pq.size()!=0)
        {
            info curr=pq.remove();
            int diff=curr.diff;
            int row=curr.row;
            int col=curr.col;
            if(row==m-1&&col==n-1)
            {
                return diff;
            }
            for(int i=0;i<4;i++)
            {
                int nrow=row+dr[i];
                int ncol=col+dc[i];
                if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n)
                {
                    int neweffort=Math.max(Math.abs(heights[row][col]-heights[nrow][ncol]),diff);
                    if(neweffort<effort[nrow][ncol])
                    {
                        effort[nrow][ncol]=neweffort;
                        pq.add(new info(neweffort,nrow,ncol));
                    }
                }
            }
        }
        return 0;
    }
}