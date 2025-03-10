class Solution {
    public boolean issafe(char arr[][],int row,int col,char dig)
    {
        for(int i=0;i<9;i++)
        {
            if(i!=row&&arr[i][col]==dig)
            {
                return false;
            }
        }
        for(int i=0;i<9;i++)
        {
            if(i!=col&&arr[row][i]==dig)
            {
                return false;
            }
        }
        int gridrow=(row/3)*3;
        int gridcol=(col/3)*3;
        for(int i=gridrow;i<gridrow+3;i++)
        {
            for(int j=gridcol;j<gridcol+3;j++)
            {
                if(i!=row&&j!=col&&arr[i][j]==dig)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
                {
                    if(!issafe(board,i,j,board[i][j]))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}