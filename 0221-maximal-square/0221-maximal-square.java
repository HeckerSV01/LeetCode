class Solution {
    private int solve(char a[][],int i,int j,Integer dp[][]){
        if(i==a.length||j==a[0].length){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int right=0;
        int down=0;
        int diag=0;
        if(a[i][j]=='0'){
            return 0;
        }else{
            right=1+solve(a,i,j+1,dp);
            down=1+solve(a,i+1,j,dp);
            diag=1+solve(a,i+1,j+1,dp);
       }
       return dp[i][j]=Math.min(right,Math.min(down,diag));
    }
    public int maximalSquare(char[][] matrix) {
        int res=0;
        Integer dp[][]=new Integer[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                res=Math.max(res,solve(matrix,i,j,dp));
            }
        }
        return res*res;
    }
}