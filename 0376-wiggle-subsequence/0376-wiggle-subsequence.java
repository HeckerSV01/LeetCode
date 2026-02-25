class Solution {
    private int cal(int a[], int i, int flag, int prev, Integer dp[][][]) {
        if (i < 0) {
            return 0;
        }
        if (dp[i][prev][flag] != null) {
            return dp[i][prev][flag];
        }
        if (flag == 1) {
            int skip = cal(a, i - 1, flag, prev, dp);
            int take = 0;
            if (prev == a.length || a[i] < a[prev]) {
                take = 1 + cal(a, i - 1, 0, i, dp);
            }
            return dp[i][prev][flag] = Math.max(skip, take);
        } else {
            int skip = cal(a, i - 1, flag, prev, dp);
            int take = 0;
            if (prev == a.length || a[i] > a[prev]) {
                take = 1 + cal(a, i - 1, 1, i, dp);
            }
            return dp[i][prev][flag] = Math.max(skip, take);
        }
    }

    public int wiggleMaxLength(int[] nums) {
        Integer dp[][][] = new Integer[nums.length][nums.length + 1][2];
        return Math.max(cal(nums, nums.length - 1, 1, nums.length, dp), cal(nums, nums.length - 1, 0, nums.length, dp));
    }
}