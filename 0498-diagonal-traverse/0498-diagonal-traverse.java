class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int res[]=new int[m*n];
        int x=0;
        int y=0;
        for(int i=0;i<res.length;i++)
        {
            res[i]=mat[x][y];
            if ((x+y)%2==0)
            {
                if(y==n-1)
                {
                    x++;
                }
                else if(x==0)
                {
                    y++;
                }
                else
                {
                    x--;
                    y++;
                }
            }
            else
            {
                if(x==m-1)
                {
                    y++;
                }
                else if(y==0)
                {
                    x++;
                }
                else
                {
                    x++;
                    y--;
                }
            }
        }
        return res;
    }
}