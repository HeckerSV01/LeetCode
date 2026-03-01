class Solution {
    private boolean solve(int a[], int i, int j, int sum1, int sum2, int turn,Boolean dp[][][]) {
        if(i>j){
            return sum1>sum2;
        }
        if(dp[i][j][turn]!=null){
            return dp[i][j][turn];
        }
        if (turn==1) {
            boolean left = solve(a, i + 1, j, sum1 + a[i], sum2, 0,dp);
            boolean right = solve(a, i, j - 1, sum1 + a[j], sum2,0,dp);
            return dp[i][j][turn]=left||right;
        } else {
            boolean left = solve(a, i + 1, j, sum1, sum2 +a[i], 1,dp);
            boolean right = solve(a, i, j - 1, sum1, sum2 + a[j], 1,dp);
            return dp[i][j][turn]=left||right;
        }
    }

    public boolean stoneGame(int[] piles) {
        Boolean dp[][][]=new Boolean[piles.length][piles.length][2];
        return solve(piles,0,piles.length-1,0,0,1,dp);
    }
}