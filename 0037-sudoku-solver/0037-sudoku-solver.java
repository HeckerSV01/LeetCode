class Solution {
    public boolean issafe(char arr[][],int row,int col,char dig)
    {
        for(int i=0;i<9;i++)
        {
            if(arr[i][col]==dig)
            {
                return false;
            }
        }
        for(int i=0;i<9;i++)
        {
            if(arr[row][i]==dig)
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
                if(arr[i][j]==dig)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean backtrack(char arr[][],int row,int col)
    {
        if(row==9&&col==0)
        {
            return true;
        }
        int nextrow=row;
        int nextcol=col+1;
        if(col+1==9)
        {
            nextrow=row+1;
            nextcol=0;
        }
        if(arr[row][col]!='.')
        {
            return backtrack(arr,nextrow,nextcol);
        }
        for(char i='1';i<='9';i++)
        {
            if(issafe(arr,row,col,i))
            {
                arr[row][col]=i;
                if(backtrack(arr,nextrow,nextcol))
                {
                    return true;
                }
                arr[row][col]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        backtrack(board,0,0);
    }
}