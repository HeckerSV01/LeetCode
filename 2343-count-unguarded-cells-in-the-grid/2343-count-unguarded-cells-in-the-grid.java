class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int a[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]=-1;
            }
        }
        for(int k[]:guards)
        {
            a[k[0]][k[1]]=1;
        }
        for(int k[]:walls)
        {
            a[k[0]][k[1]]=2;
        }
        for(int k[]:guards)
        {
            int row=k[0];
            int col=k[1];
            int nrow=row;
            int ncol=col+1;
            while(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&a[nrow][ncol]!=1&&a[nrow][ncol]!=2)
            {
                a[nrow][ncol]=3;
                ncol++;
            }
            nrow=row;
            ncol=col-1;
            while(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&a[nrow][ncol]!=1&&a[nrow][ncol]!=2)
            {
                a[nrow][ncol]=3;
                ncol--;
            }
            nrow=row+1;
            ncol=col;
            while(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&a[nrow][ncol]!=1&&a[nrow][ncol]!=2)
            {
                a[nrow][ncol]=3;
                nrow++;
            }
            nrow=row-1;
            ncol=col;
            while(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&a[nrow][ncol]!=1&&a[nrow][ncol]!=2)
            {
                a[nrow][ncol]=3;
                nrow--;
            }
        }
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i][j]==-1)
                {
                    count++;
                }
            }
        }
        return count;
    }
}