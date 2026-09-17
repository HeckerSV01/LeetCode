class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int neg=0;
        int firstnegativeno=Integer.MAX_VALUE;
        long sum=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<0){
                    neg++;
                }
                firstnegativeno=Math.min(firstnegativeno,Math.abs(matrix[i][j]));
                sum=sum+Math.abs(matrix[i][j]);
            }
        }
        if(neg%2==0){
            return sum;
        }else{
            return sum-2L*firstnegativeno;
        }
    }
}