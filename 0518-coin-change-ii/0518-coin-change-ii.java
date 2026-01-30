class Solution {
    private int cal(int a[], int i, int target, int dp[][]) {
        if (i == 0) {
            return (target % a[0] == 0) ? 1 : 0;
        }
        if (dp[i][target] != -1) {
            return dp[i][target];
        }
        int notselect = cal(a, i - 1, target, dp);
        int select = 0;
        if (a[i] <= target) {
            select = cal(a, i, target - a[i], dp);
        }
        return dp[i][target] = notselect + select;
    }

    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }
        return cal(coins, coins.length - 1, amount, dp);
    }
}