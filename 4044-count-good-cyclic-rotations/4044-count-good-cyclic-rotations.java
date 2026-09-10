class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int half = n / 2;
        long[] prefix = new long[2 * n + 1];
        for (int i = 0; i < 2 * n; i++) {
            prefix[i + 1] = prefix[i] + nums[i % n];
        }
        long total = prefix[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long firstHalf = prefix[i + half] - prefix[i];
            long secondHalf = total - firstHalf;
            if (firstHalf > secondHalf) {
                ans++;
            }
        }
        return ans;
    }
}