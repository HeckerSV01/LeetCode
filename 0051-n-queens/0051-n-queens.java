class Solution {
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
    public static void solve(List<List<String>> main,char arr[][],int row)
    {
       if(row==arr.length)
       {
        List<String> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            char aux[]=arr[i];
            list.add(new String(aux));
        }
        main.add(list);
        return;
       }
       for(int i=0;i<arr.length;i++)
       {
        if(issafe(arr,row,i))
        {
            arr[row][i]='Q';
            solve(main,arr,row+1);
            arr[row][i]='.';
        }
       }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> main=new ArrayList<>();
        char arr[][]=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]='.';
            }
        }
        solve(main,arr,0);
        return main;
    }
}