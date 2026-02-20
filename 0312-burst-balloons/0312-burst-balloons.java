class Solution {
    public int maxCoins(int[] nums) {
        int a[] = new int[nums.length + 2];
        a[0] = 1;
        a[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            a[i + 1] = nums[i];
        }
        int dp[][] = new int[a.length][a.length];
        for (int i = a.length - 1; i >= 1; i--) {
            for (int j = 1; j < a.length - 1; j++) {
                if (i > j) {
                    continue;
                }
                int max = -1;
                for (int k = i; k <= j; k++) {
                    int cost = a[i - 1] * a[j + 1] * a[k] + dp[i][k - 1] + dp[k + 1][j];
                    max = Math.max(max, cost);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][a.length - 2];
    }
}