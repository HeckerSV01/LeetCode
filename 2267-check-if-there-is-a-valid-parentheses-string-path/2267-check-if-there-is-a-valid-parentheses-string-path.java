class Solution {
    private boolean solve(char grid[][],int i,int j,int counter,int m,int n,Boolean dp[][][]){
        if(i<0||j<0||i>m||j>n){
            return false;
        }
        if(grid[i][j]=='('){
            counter++;
        }else{
            counter--;
        }
        if(counter<0){
            return false;
        }
        if(i==m&&j==n&&counter==0){
            return counter==0;
        }
        if(dp[i][j][counter]!=null){
            return dp[i][j][counter];
        }
        boolean down=solve(grid,i+1,j,counter,m,n,dp);
        boolean right=solve(grid,i,j+1,counter,m,n,dp);
        return dp[i][j][counter]=down||right;
    }
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length-1;
        int n=grid[0].length-1;
        Boolean dp[][][]=new Boolean[m+1][n+1][m+n+2];
        return solve(grid,0,0,0,m,n,dp);
    }
}