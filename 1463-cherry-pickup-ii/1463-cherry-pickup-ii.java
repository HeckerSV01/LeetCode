class Solution {
    private int cal(int i, int j1, int j2, int a[][], int dp[][][], int m, int n) {
        if (j1 < 0 || j1 > n - 1 || j2 < 0 || j2 > n - 1) {
            return -1_000_000_000;
        }
        if (i == m - 1) {
            if (j1 == j2) {
                return a[i][j1];
            } else {
                return a[i][j1] + a[i][j2];
            }
        }
        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }
        int max = Integer.MIN_VALUE;
        for (int j = -1; j <= 1; j++) {
            for (int k = -1; k <= 1; k++) {
                if (j1 == j2) {
                    max = Math.max(max, a[i][j1] + cal(i + 1, j1 + j, j2 + k, a, dp, m, n));
                } else {
                    max = Math.max(max, a[i][j1] + a[i][j2] + cal(i + 1, j1 + j, j2 + k, a, dp, m, n));
                }
            }
        }
        return dp[i][j1][j2] = max;
    }

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][][] = new int[m][n][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return cal(0, 0, n - 1, grid, dp, m, n);
    }
}