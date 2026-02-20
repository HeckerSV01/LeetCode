class Solution {
    private int cal(int a[], int i, int j, int dp[][]) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int max = -1;
        for (int k = i; k <= j; k++) {
            int cost = a[i - 1] * a[j + 1] * a[k] + cal(a, i, k - 1, dp) + cal(a, k + 1, j, dp);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }

    public int maxCoins(int[] nums) {
        int a[] = new int[nums.length + 2];
        a[0] = 1;
        a[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            a[i + 1] = nums[i];
        }
        int dp[][] = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                dp[i][j] = -1;
            }
        }
        return cal(a, 1, a.length - 2, dp);
    }
}