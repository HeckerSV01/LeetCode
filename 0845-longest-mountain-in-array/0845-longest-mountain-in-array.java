class Solution {
    public int longestMountain(int[] arr) {
        int dp1[] = new int[arr.length];
        int dp2[] = new int[arr.length];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                dp1[i + 1] = dp1[i] + 1;
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                dp2[i] = dp2[i + 1] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dp1[i] > 1 && dp2[i] > 1) {
                res = Math.max(res, dp1[i] + dp2[i] - 1);
            }
        }
        return res;
    }
}