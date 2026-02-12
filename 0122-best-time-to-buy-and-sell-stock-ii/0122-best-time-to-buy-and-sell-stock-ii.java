class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            int buy = -prices[i] + dp[i + 1][0];
            int skipBuy = dp[i + 1][1];
            dp[i][1] = Math.max(buy, skipBuy);
            int sell = prices[i] + dp[i + 1][1];
            int skipSell = dp[i + 1][0];
            dp[i][0] = Math.max(sell, skipSell);
        }
        return dp[0][1];
    }
}
