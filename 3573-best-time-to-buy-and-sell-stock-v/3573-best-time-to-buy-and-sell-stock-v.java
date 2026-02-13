class Solution {
    private long cal(int a[], int i, int k, int type, long dp[][][]) {
        if (i == a.length) {
            if (type == 0) {
                return 0;
            }
            return Long.MIN_VALUE / 2;
        }

        if (k == 0) {
            if (type == 0) {
                return 0;
            }
            return Long.MIN_VALUE / 2;
        }
        if (dp[i][k][type] != -1) {
            return dp[i][k][type];
        }
        if (type == 0) {
            long buynormal = -a[i] + cal(a, i + 1, k, 1, dp);
            long sellshort = a[i] + cal(a, i + 1, k, 2, dp);
            long skip = cal(a, i + 1, k, 0, dp);
            return dp[i][k][type] = Math.max(buynormal, Math.max(skip, sellshort));
        } else if (type == 1) {
            long sell = a[i] + cal(a, i + 1, k - 1, 0, dp);
            long skip = cal(a, i + 1, k, 1, dp);
            return dp[i][k][type] = Math.max(sell, skip);
        } else {
            long buy = -a[i] + cal(a, i + 1, k - 1, 0, dp);
            long skip = cal(a, i + 1, k, 2, dp);
            return dp[i][k][type] = Math.max(buy, skip);
        }
    }

    public long maximumProfit(int[] prices, int k) {
        long dp[][][] = new long[prices.length][k + 1][3];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                for (int l = 0; l < 3; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return cal(prices, 0, k, 0, dp);
    }
}