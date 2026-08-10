class Solution {
    private int solve(int a[], int i, int m, int aliceTurn, Integer dp[][][]) {
        if (i >= a.length) {
            return 0;
        }
        if (dp[i][m][aliceTurn] != null) {
            return dp[i][m][aliceTurn];
        }
        int res = 0;
        if (aliceTurn == 1) {
            res = 0;
        } else {
            res = Integer.MAX_VALUE;
        }
        if (aliceTurn == 1) {
            for (int j = 1; j <= 2 * m && i + j <= a.length; j++) {
                int sum = 0;
                for (int k = i; k < i + j; k++) {
                    sum = sum + a[k];
                }
                res = Math.max(res, sum + solve(a, i + j, Math.max(m, j), 0, dp));
            }
        } else {
            for (int j = 1; j <= 2 * m && i + j <= a.length; j++) {
                res = Math.min(res, solve(a, i + j, Math.max(m, j), 1, dp));
            }
        }
        return dp[i][m][aliceTurn] = res;
    }

    public int stoneGameII(int[] piles) {
        Integer dp[][][] = new Integer[piles.length][piles.length+1][2];
        return solve(piles, 0, 1, 1, dp);
    }
}