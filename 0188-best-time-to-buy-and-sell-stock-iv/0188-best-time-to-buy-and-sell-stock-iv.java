class Solution {
    private int cal(int a[], int i, int canbuy, int k, int dp[][][]) {
        if (i == a.length) {
            return 0;
        }
        if (k == 0) {
            return 0;
        }
        if (dp[i][canbuy][k] != -1) {
            return dp[i][canbuy][k];
        }
        if (canbuy == 1) {
            int buy = -a[i] + cal(a, i + 1, 0, k, dp);
            int skip = cal(a, i + 1, 1, k, dp);
            return dp[i][canbuy][k] = Math.max(buy, skip);
        } else {
            int sell = a[i] + cal(a, i + 1, 1, k - 1, dp);
            int skip = cal(a, i + 1, 0, k, dp);
            return dp[i][canbuy][k] = Math.max(sell, skip);
        }
    }

    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length][2][k + 1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int l = 0; l < k + 1; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return cal(prices, 0, 1, k, dp);
    }
}