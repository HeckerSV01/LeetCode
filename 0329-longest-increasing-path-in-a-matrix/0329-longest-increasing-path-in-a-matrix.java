class Solution {
    private int solve(int a[][],int i,int j,int dir[][],Integer dp[][]){
        if(i<0||i>=a.length||j<0||j>=a[0].length){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int len=1;
        for(int k=0;k<4;k++){
            if(i+dir[k][0]>=0&&i+dir[k][0]<a.length&&j+dir[k][1]<a[0].length&&j+dir[k][1]>=0&&a[i+dir[k][0]][j+dir[k][1]]>a[i][j]){
                len=Math.max(len,1+solve(a,i+dir[k][0],j+dir[k][1],dir,dp));
            }
        }
        return dp[i][j]=len;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
        Integer dp[][]=new Integer[matrix.length][matrix[0].length];
        int res=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                res=Math.max(res,solve(matrix,i,j,dir,dp));
            }
        }
        return res;
    }
}