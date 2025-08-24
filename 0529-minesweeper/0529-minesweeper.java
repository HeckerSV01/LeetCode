class Solution {
    public int countmines(char board[][],int click[],int m,int n)
    {
        int count=0;
            int row=click[0]-1;
            int col=click[1];
            if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='M')
            {
                count++;
            }
            row=click[0]+1;
            col=click[1];
            if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='M')
            {
                count++;
            }
            row=click[0];
            col=click[1]-1;
            if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='M')
            {
                count++;
            }
            row=click[0];
            col=click[1]+1;
            if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='M')
            {
                count++;
            }
            row=click[0]-1;
            col=click[1]-1;
            if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='M')
            {
                count++;
            }
            row=click[0]-1;
            col=click[1]+1;
            if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='M')
            {
                count++;
            }
            row=click[0]+1;
            col=click[1]-1;
            if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='M')
            {
                count++;
            }
            row=click[0]+1;
            col=click[1]+1;
            if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='M')
            {
                count++;
            }
        return count;
    }
    public void dfs(char board[][],int vis[][],int click[],int m,int n)
    {
        if(countmines(board,click,m,n)!=0)
        {
            board[click[0]][click[1]]=(char)(countmines(board,click,m,n)+'0');
            vis[click[0]][click[1]]=1;
            return;
        }
        else
        {
            board[click[0]][click[1]]='B';
            vis[click[0]][click[1]]=1;
        }
        int row=click[0]-1;
        int col=click[1];
        if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='E'&&vis[row][col]==0)
        {
            dfs(board,vis,new int[]{row,col},m,n);
        }
        row=click[0]+1;
        col=click[1];
        if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='E'&&vis[row][col]==0)
        {
            dfs(board,vis,new int[]{row,col},m,n);
        }
        row=click[0];
        col=click[1]-1;
        if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='E'&&vis[row][col]==0)
        {
            dfs(board,vis,new int[]{row,col},m,n);
        }
        row=click[0];
        col=click[1]+1;
        if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='E'&&vis[row][col]==0)
        {
            dfs(board,vis,new int[]{row,col},m,n);
        }
        row=click[0]-1;
        col=click[1]-1;
        if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='E'&&vis[row][col]==0)
        {
            dfs(board,vis,new int[]{row,col},m,n);
        }
        row=click[0]+1;
        col=click[1]-1;
        if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='E'&&vis[row][col]==0)
        {
            dfs(board,vis,new int[]{row,col},m,n);
        }
        row=click[0]-1;
        col=click[1]+1;
        if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='E'&&vis[row][col]==0)
        {
            dfs(board,vis,new int[]{row,col},m,n);
        }
        row=click[0]+1;
        col=click[1]+1;
        if(row>=0&&row<m&&col>=0&&col<n&&board[row][col]=='E'&&vis[row][col]==0)
        {
            dfs(board,vis,new int[]{row,col},m,n);
        }
    }
    public char[][] updateBoard(char[][] board, int[] click) {
        int m=board.length;
        int n=board[0].length;
        int vis[][]=new int[m][n];
        if(board[click[0]][click[1]]=='M')
        {
            board[click[0]][click[1]]='X';
            return board;
        }
        if(board[click[0]][click[1]]=='E')
        {
            dfs(board,vis,click,m,n);
        }
        return board;
    }
}