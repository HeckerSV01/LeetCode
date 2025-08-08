class Solution {
    public void bfs(int i,int j,int vis[][],char a[][])
    {
        vis[i][j]=1;
        Queue<Pair<Integer,Integer>> q=new LinkedList<>();
        q.add(new Pair<>(i,j));
        while(!q.isEmpty())
        {
            Pair<Integer,Integer> p=q.remove();
            int row=p.getKey();
            int col=p.getValue();
            int nrow=0;
            int ncol=0;
            nrow=row-1;
            ncol=col;
            if(nrow>=0&&nrow<a.length&&ncol>=0&&ncol<a[0].length&&a[nrow][ncol]=='1'&&vis[nrow][ncol]==0)
            {
                vis[nrow][ncol]=1;
                q.add(new Pair<>(nrow,ncol));
            }
            nrow=row+1;
            ncol=col;
            if(nrow>=0&&nrow<a.length&&ncol>=0&&ncol<a[0].length&&a[nrow][ncol]=='1'&&vis[nrow][ncol]==0)
            {
                vis[nrow][ncol]=1;
                q.add(new Pair<>(nrow,ncol));
            }
            nrow=row;
            ncol=col-1;
            if(nrow>=0&&nrow<a.length&&ncol>=0&&ncol<a[0].length&&a[nrow][ncol]=='1'&&vis[nrow][ncol]==0)
            {
                vis[nrow][ncol]=1;
                q.add(new Pair<>(nrow,ncol));
            }
            nrow=row;
            ncol=col+1;
            if(nrow>=0&&nrow<a.length&&ncol>=0&&ncol<a[0].length&&a[nrow][ncol]=='1'&&vis[nrow][ncol]==0)
            {
                vis[nrow][ncol]=1;
                q.add(new Pair<>(nrow,ncol));
            }
        }
    }
    public int numIslands(char[][] grid) {
        int vis[][]=new int[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(vis[i][j]==0&&grid[i][j]=='1')
                {
                    bfs(i,j,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }
}