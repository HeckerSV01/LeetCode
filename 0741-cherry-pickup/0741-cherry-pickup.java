class Solution {
    public int cal(int i1, int i2, int j1, int a[][], int dp[][][], int m) {
        int j2 = i1 + j1 - i2;
        if (i1 > m - 1 || j1 > m - 1 || j2 > m - 1 || i2 > m - 1 || a[i1][j1] == -1 || a[i2][j2] == -1) {
            return -1_000_000_000;
        }
        if (i1 == m - 1 && j1 == m - 1) {
            return a[i1][j1];
        }
        if (dp[i1][i2][j1] != -1) {
            return dp[i1][i2][j1];
        }
        int max = Integer.MIN_VALUE;
        if (i1 == i2 && j1 == j2) {
            max = Math.max(
                    Math.max(a[i1][j1] + cal(i1 + 1, i2 + 1, j1, a, dp, m), a[i1][j1] + cal(i1 + 1, i2, j1, a, dp, m)),
                    Math.max(a[i1][j1] + cal(i1, i2 + 1, j1 + 1, a, dp, m), a[i1][j1] + cal(i1, i2, j1 + 1, a, dp, m)));
        } else {
            max = Math.max(
                    Math.max(a[i1][j1] + a[i2][j2] + cal(i1 + 1, i2 + 1, j1, a, dp, m),
                            a[i1][j1] + a[i2][j2] + cal(i1 + 1, i2, j1, a, dp, m)),
                    Math.max(a[i1][j1] + a[i2][j2] + cal(i1, i2 + 1, j1 + 1, a, dp, m),
                            a[i1][j1] + a[i2][j2] + cal(i1, i2, j1 + 1, a, dp, m)));
        }
        return dp[i1][i2][j1] = max;
    }

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int dp[][][] = new int[m][m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return Math.max(0, cal(0, 0, 0, grid, dp, m));
    }
}