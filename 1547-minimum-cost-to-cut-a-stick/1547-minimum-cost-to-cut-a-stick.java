class Solution {
    private int cal(int a[], int i, int j, int dp[][]) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = a[j + 1] - a[i - 1] + cal(a, i, k - 1, dp) + cal(a, k + 1, j, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int arr[] = new int[cuts.length + 2];
        arr[0] = 0;
        arr[cuts.length + 1] = n;
        for (int i = 1; i <= cuts.length; i++) {
            arr[i] = cuts[i - 1];
        }
        int dp[][] = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                dp[i][j] = -1;
            }
        }
        return cal(arr, 1, arr.length - 2, dp);
    }
}