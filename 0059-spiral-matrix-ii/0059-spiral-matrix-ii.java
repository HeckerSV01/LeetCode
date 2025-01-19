class Solution {
    public int[][] generateMatrix(int n) {
        int mat[][]=new int[n][n];
        int rowst=0;
        int rowen=n-1;
        int colst=0;
        int colen=n-1;
        int k=1;
        while(rowst<=rowen&&colst<=colen)
        {
            for(int i=colst;i<=colen;i++)
            {
                mat[rowst][i]=k++;
            }
            rowst++;
            for(int i=rowst;i<=rowen;i++)
            {
                mat[i][colen]=k++;
            }
            colen--;
            for(int i=colen;i>=colst;i--)
            {
                mat[rowen][i]=k++;
            }
            rowen--;
            for(int i=rowen;i>=rowst;i--)
            {
                mat[i][colst]=k++;
            }
            colst++;
        }
        return mat;
    }
}