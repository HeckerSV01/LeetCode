class Solution {
    private int cal(int a[], int i, int canbuy, int dp[][]) {
        if (i > a.length - 1) {
            return 0;
        }
        if (dp[i][canbuy] != -1) {
            return dp[i][canbuy];
        }
        if (canbuy == 1) {
            int buy = -a[i] + cal(a, i + 1, 0, dp);
            int skip = cal(a, i + 1, 1, dp);
            return dp[i][canbuy] = Math.max(buy, skip);
        } else {
            int sell = a[i] + cal(a, i + 2, 1, dp);
            int skip = cal(a, i + 1, 0, dp);
            return dp[i][canbuy] = Math.max(sell, skip);
        }
    }
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return cal(prices, 0, 1, dp);
    }
}