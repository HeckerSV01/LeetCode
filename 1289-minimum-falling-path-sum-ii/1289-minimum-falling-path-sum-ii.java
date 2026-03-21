class Solution {
    public int minFallingPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            dp[grid.length - 1][i] = grid[grid.length - 1][i];
        }
        for (int i = grid[0].length - 2; i >= 0; i--) {
            for (int j = grid.length - 1; j >= 0; j--) {
                int res = 0;
                int min = 1000000000;
                for (int k = 0; k < grid.length; k++) {
                    if (k != j) {
                        res = grid[i][j] + dp[i + 1][k];
                        min = Math.min(min, res);
                    }
                }
                dp[i][j] = min;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < grid.length; j++) {
            res = Math.min(res, dp[0][j]);
        }

        return res;
    }
}