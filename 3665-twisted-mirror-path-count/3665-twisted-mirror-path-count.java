class Solution {
    final int MOD=1000000007;
    private int solve(int grid[][],int i,int j,int isdown,Integer dp[][][]){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length){
            return 0;
        }
        if(i==grid.length-1&&j==grid[0].length-1){
            return 1;
        }
        if(dp[i][j][isdown]!=null){
            return dp[i][j][isdown];
        }
        int count=0;
        if(grid[i][j]==0){
            count=(count+solve(grid,i+1,j,1,dp)+solve(grid,i,j+1,0,dp))%MOD;
        }else{
            if(isdown==1){
                count=(count+solve(grid,i,j+1,0,dp))%MOD;
            }else{
                count=(count+solve(grid,i+1,j,1,dp))%MOD;
            }
        }
        return dp[i][j][isdown]=(count)%MOD;
    }
    public int uniquePaths(int[][] grid) {
        Integer dp[][][]=new Integer[grid.length][grid[0].length][3];
        return solve(grid,0,0,2,dp);
    }
}