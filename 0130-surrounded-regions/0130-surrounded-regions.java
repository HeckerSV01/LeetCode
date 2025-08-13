class Solution {
    public void dfs(int i,int j,int vis[][],char a[][],int m,int n)
    {
        vis[i][j]=1;
        int row=0;
        int col=0;
        row=i-1;
        col=j;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]=='O'&&vis[row][col]==0)
        {
            dfs(row,col,vis,a,m,n);
        }
        row=i+1;
        col=j;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]=='O'&&vis[row][col]==0)
        {
            dfs(row,col,vis,a,m,n);
        }
        row=i;
        col=j-1;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]=='O'&&vis[row][col]==0)
        {
            dfs(row,col,vis,a,m,n);
        }
        row=i;
        col=j+1;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]=='O'&&vis[row][col]==0)
        {
            dfs(row,col,vis,a,m,n);
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int vis[][]=new int[m][n];
        for(int i=0;i<n;i++)
        {
            if(board[0][i]=='O'&&vis[0][i]==0)
            {
                dfs(0,i,vis,board,m,n);
            }
            if(board[m-1][i]=='O'&&vis[m-1][i]==0)
            {
                dfs(m-1,i,vis,board,m,n);
            }
        }
        for(int i=0;i<m;i++)
        {
            if(board[i][0]=='O'&&vis[i][0]==0)
            {
                dfs(i,0,vis,board,m,n);
            }
            if(board[i][n-1]=='O'&&vis[i][n-1]==0)
            {
                dfs(i,n-1,vis,board,m,n);
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(vis[i][j]==0&&board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }
    }
}