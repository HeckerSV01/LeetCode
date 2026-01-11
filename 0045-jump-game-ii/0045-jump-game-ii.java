class Solution {
    public int cal(int i, int nums[], int dp[]) {
        if (i >= nums.length - 1)
            return 0;
        if (nums[i] == 0)
            return Integer.MAX_VALUE;
        if (dp[i] != -1) {
            return dp[i];
        }
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= nums[i]; j++) {
            int next = cal(i + j, nums, dp);
            if (next != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + next);
            }
        }
        return dp[i] = min;
    }

    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return cal(0, nums, dp);
    }
}