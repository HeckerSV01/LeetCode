class Solution {
    private int cal(List<Integer> num, int i, int target, int dp[][]) {
        if (target == 0) {
            return 0;
        }
        if (i > num.size() - 1 || target < 0) {
            return -1000000000;
        }
        if (dp[i][target] != -1) {
            return dp[i][target];
        }
        int notpick = cal(num, i + 1, target, dp);
        int pick = 1 + cal(num, i + 1, target - num.get(i), dp);
        return dp[i][target] = Math.max(notpick, pick);
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int dp[][] = new int[nums.size()][target + 1];
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        int res = cal(nums, 0, target, dp);
        return (res < 0) ? -1 : res;
    }
}