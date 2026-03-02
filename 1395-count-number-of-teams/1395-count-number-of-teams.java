class Solution {

    private int lis(int a[], int i, int k, int prev, int dp[][][]) {

        if (k == 0) return 1;
        if (i == a.length) return 0;

        int previdx = prev + 1;

        if (dp[i][k][previdx] != -1) {
            return dp[i][k][previdx];
        }

        int take = 0;

        if (prev == -1 || a[prev] < a[i]) {
            take = lis(a, i + 1, k - 1, i, dp);
        }

        int skip = lis(a, i + 1, k, prev, dp);

        return dp[i][k][previdx] = take + skip;
    }

    private int lds(int a[], int i, int k, int prev, int dp[][][]) {

        if (k == 0) return 1;
        if (i == a.length) return 0;

        int previdx = prev + 1;

        if (dp[i][k][previdx] != -1) {
            return dp[i][k][previdx];
        }

        int take = 0;

        if (prev == -1 || a[prev] > a[i]) {
            take = lds(a, i + 1, k - 1, i, dp);
        }

        int skip = lds(a, i + 1, k, prev, dp);

        return dp[i][k][previdx] = take + skip;
    }

    public int numTeams(int[] rating) {

        int n = rating.length;

        int dp1[][][] = new int[n][4][n + 1];
        int dp2[][][] = new int[n][4][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                Arrays.fill(dp1[i][j], -1);
                Arrays.fill(dp2[i][j], -1);
            }
        }

        return lis(rating, 0, 3, -1, dp1) + lds(rating, 0, 3, -1, dp2);
    }
}