class Solution {
    private int solve(int a1[], int a2[], int i, int j, int dp[][]) {
        if (i == a1.length || j == a2.length) {
            return Integer.MIN_VALUE;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int skip1 = solve(a1, a2, i + 1, j, dp);
        int skip2 = solve(a1, a2, i, j + 1, dp);
        int take = a1[i] * a2[j] + Math.max(0, solve(a1, a2, i + 1, j + 1, dp));
        return dp[i][j] = Math.max(skip1, Math.max(skip2, take));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(nums1, nums2, 0, 0, dp);
    }
}