class Solution {
    private int cal(int i, int a[], int target, int dp[][]) {
        if (i == 0) {
            if (target == 0 && a[0] == 0) {
                return 2;
            }
            if (target == 0 || a[0] == target) {
                return 1;
            }
            return 0;
        }
        if (dp[i][target] != -1) {
            return dp[i][target];
        }
        int notpick = cal(i - 1, a, target, dp);
        int pick = 0;
        if (a[i] <= target) {
            pick = cal(i - 1, a, target - a[i], dp);
        }
        return dp[i][target] = pick + notpick;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int k : nums) {
            sum = sum + k;
        }
        if (sum < Math.abs(target)) return 0;
        if ((sum + target) % 2 != 0) return 0;
        int t = (sum + target) / 2;
        int dp[][] = new int[nums.length][t + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= t; j++) {
                dp[i][j] = -1;
            }
        }
        return cal(nums.length - 1, nums, t, dp);
    }
}