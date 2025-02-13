class Solution {
    static int count;
    public static boolean issafe(char arr[][],int row,int col)
    {
        for(int i=row-1;i>=0;i--)
        {
            if(arr[i][col]=='Q')
            {
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--)
        {
            if(arr[i][j]=='Q')
            {
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0&&j<arr.length;i--,j++)
        {
            if(arr[i][j]=='Q')
            {
                return false;
            }
        }
        return true;
    }
    public static void solve(char arr[][],int row)
    {
       if(row==arr.length)
       {
        count++;
        return;
       }
       for(int i=0;i<arr.length;i++)
       {
        if(issafe(arr,row,i))
        {
            arr[row][i]='Q';
            solve(arr,row+1);
            arr[row][i]='.';
        }
       }
    }
    public int totalNQueens(int n) {
        count=0;
        char arr[][]=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]='.';
            }
        }
        solve(arr,0);
       return count;
    }
}