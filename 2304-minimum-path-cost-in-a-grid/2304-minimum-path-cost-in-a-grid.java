class Solution {
    private int solve(int grid[][],int costs[][],int i,int j,int dp[][]){
        if(i==grid.length-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=0;k<grid[0].length;k++){
            int sum=costs[grid[i][j]][k]+grid[i][j]+solve(grid,costs,i+1,k,dp);
            min=Math.min(min,sum);
        }
        return dp[i][j]=min;
    }
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int dp[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dp[i][j]=-1;
            }
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            res=Math.min(res,solve(grid,moveCost,0,i,dp));
        }
        return res;
    }
}