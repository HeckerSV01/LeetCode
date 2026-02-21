class Solution {
    private int cal(int a[], int i, int k, int dp[]) {
        if (i == a.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int max = -1;
        int maxnum = -1;
        for (int j = i; j < Math.min(i + k, a.length); j++) {
            maxnum = Math.max(maxnum, a[j]);
            int steps = maxnum * (j - i + 1) + cal(a, j + 1, k, dp);
            max = Math.max(max, steps);
        }
        return dp[i] = max;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        return cal(arr, 0, k, dp);
    }
}