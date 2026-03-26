class Solution {
    private int max(int a[]) {
        int res = 0;
        for (int k : a) {
            res = Math.max(res, k);
        }
        return res;
    }

    private int boqready(int a[], int n, int f) {
        int res = 0;
        int conseq = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= n) {
                conseq++;
                if (conseq == f) {
                    res++;
                    conseq = 0;
                }
            } else {
                conseq = 0;
            }
        }
        return res;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if ((long)m * k > bloomDay.length) {
            return -1;
        }
        int mx = max(bloomDay);
        int f = 1;
        int l = mx;
        int res = Integer.MAX_VALUE;
        while (f <= l) {
            int mid = f + (l - f) / 2;
            int temp = boqready(bloomDay, mid, k);
            if (temp < m) {
                f = mid + 1;
            } else if (temp >= m) {
                res = Math.min(res, mid);
                l = mid - 1;
            }
        }
        return res;
    }
}