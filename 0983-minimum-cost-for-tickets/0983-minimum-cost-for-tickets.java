class Solution {
    private int recur(int a[], int cost[], int i, int dp[]) {
        if (i >= a.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int oned = cost[0] + recur(a, cost, fn(a, i, 1), dp);
        int sevend = cost[1] + recur(a, cost, fn(a, i, 7), dp);
        int thirtyd = cost[2] + recur(a, cost, fn(a, i, 30), dp);
        return dp[i] = Math.min(oned, Math.min(sevend, thirtyd));
    }

    private int fn(int a[], int i, int x) {
        int k = a[i] + x - 1;
        int res = a.length;
        for (int j = i + 1; j < a.length; j++) {
            if (a[j] > k) {
                res = j;
                break;
            }
        }
        return res;
    }

    public int mincostTickets(int[] days, int[] costs) {
        int min = Integer.MAX_VALUE;
        int dp[] = new int[days.length];
        Arrays.fill(dp, -1);
        return recur(days, costs, 0, dp);
    }
}