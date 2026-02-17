class Solution {
    public int findNumberOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int count[] = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxlen = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && 1 + dp[j] > dp[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    count[i] = count[j];
                } else if (nums[j] < nums[i] && dp[j] + 1 == dp[i]) {
                    count[i] = count[j] + count[i];
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == maxlen) {
                res = res + count[i];
            }
        }
        return res;
    }
}