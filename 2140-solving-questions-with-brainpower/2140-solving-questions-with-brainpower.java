class Solution {
    private long cal(int a[][], int i, long dp[]) {
        if (i >= a.length) {
            return 0;
        }
        if (i == a.length - 1) {
            return a[a.length - 1][0];
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        long skip = cal(a, i + 1, dp);
        long notskip = a[i][0] + cal(a, i + a[i][1] + 1, dp);
        return dp[i] = Math.max(skip, notskip);
    }

    public long mostPoints(int[][] questions) {
        int m = questions.length;
        long dp[] = new long[m];
        Arrays.fill(dp, -1);
        return cal(questions, 0, dp);
    }
}