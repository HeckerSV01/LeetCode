class Solution {
    private int cal(int i, int a[], int dp[], int target) {
        if (i == a.length - 1) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int max = -100000000;
        for (int j = i + 1; j < a.length; j++) {
            if (Math.abs(a[i] - a[j]) <= target) {
                max = Math.max(max, 1 + cal(j, a, dp, target));
            }
        }
        return dp[i] = max;
    }

    public int maximumJumps(int[] nums, int target) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        int res = cal(0, nums, dp, target);
        if (res > 0) {
            return res;
        } else {
            return -1;
        }
    }
}