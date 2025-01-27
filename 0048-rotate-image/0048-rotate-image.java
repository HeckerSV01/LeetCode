class Solution {
    public void rotate(int[][] matrix) {
        int st=0;
        int en=matrix.length-1;
        while(st<en)
        {
            for(int i=0;i<matrix[0].length;i++)
            {
                int temp=matrix[st][i];
                matrix[st][i]=matrix[en][i];
                matrix[en][i]=temp;
            }
            st++;
            en--;
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=i+1;j<matrix[0].length;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
}