class Solution {
    public int count(int a[][],int i,int j,int m,int n)
    {
        int c=0;
        int row=0;
        int col=0;
        row=i-1;
        col=j;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]==1)
        {
            c++;
        }
        row=i+1;
        col=j;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]==1)
        {
            c++;
        }
        row=i;
        col=j-1;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]==1)
        {
            c++;
        }
        row=i;
        col=j+1;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]==1)
        {
            c++;
        }
        row=i-1;
        col=j-1;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]==1)
        {
            c++;
        }
        row=i-1;
        col=j+1;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]==1)
        {
            c++;
        }
        row=i+1;
        col=j-1;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]==1)
        {
            c++;
        }
        row=i+1;
        col=j+1;
        if(row>=0&&row<m&&col>=0&&col<n&&a[row][col]==1)
        {
            c++;
        }
        return c;
    }
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        int temp[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==1)
                {
                    if(count(board,i,j,m,n)==2||count(board,i,j,m,n)==3)
                    {
                        temp[i][j]=1;
                    }
                    else
                    {
                        temp[i][j]=0;
                    } 
                }
                else
                {
                    if(count(board,i,j,m,n)==3)
                    {
                        temp[i][j]=1;
                    }
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]=temp[i][j];
            }
        }
    }
}