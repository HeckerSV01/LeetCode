class Solution {
    private int cal(int a[], int target, int dp[]) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int count = 0;
        for (int j = 0; j < a.length; j++) {
            count = count + cal(a, target - a[j], dp);
        }
        return dp[target] = count;
    }

    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target + 1];
        Arrays.fill(dp, -1);
        return cal(nums, target, dp);
    }
}