class Solution {
    private int cal(int a[], int val, int i, int dp[][]) {
        if (i == 0) {
            if (val % a[0] == 0) {
                return val / a[0];
            } else {
                return 1000000000;
            }
        }
        if (dp[i][val] != -1) {
            return dp[i][val];
        }
        int nottake = 0 + cal(a, val, i - 1, dp);
        int take = Integer.MAX_VALUE;
        if (a[i] <= val) {
            take = 1 + cal(a, val - a[i], i, dp);
        }
        return dp[i][val] = Math.min(take, nottake);
    }

    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }
        int res = cal(coins, amount, coins.length - 1, dp);
        return res >= 1000000000 ? -1 : res;
    }
}