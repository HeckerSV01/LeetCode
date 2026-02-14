class Solution {
    private int cal(int a[], int i, int prev, int dp[][]) {
        if (i < 0) {
            return 0;
        }
        if (dp[i][prev] != -1) {
            return dp[i][prev];
        }
        int notpick = cal(a, i - 1, prev, dp);
        int pick = 0;
        if (prev == a.length || a[i] < a[prev]) {
            pick = 1 + cal(a, i - 1, i, dp);
        }
        return dp[i][prev] = Math.max(pick, notpick);
    }

    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return cal(nums, nums.length - 1, nums.length, dp);
    }
}