class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l=new ArrayList<>();
        int rowst=0;
        int rowen=matrix.length-1;
        int colst=0;
        int colen=matrix[0].length-1;
        while(rowst<=rowen&&colst<=colen)
        {
            for(int i=colst;i<=colen;i++)
            {
                l.add(matrix[rowst][i]);
            }
            rowst++;
            for(int i=rowst;i<=rowen;i++)
            {
                l.add(matrix[i][colen]);
            }
            colen--;
            if(rowst<=rowen)
            {
            for(int i=colen;i>=colst;i--)
            {
                l.add(matrix[rowen][i]);
            }
            rowen--;
            }
            if(colst<=colen)
            {
            for(int i=rowen;i>=rowst;i--)
            {
                l.add(matrix[i][colst]);
            }
            colst++;
            }
        }
        return l;
    }
}