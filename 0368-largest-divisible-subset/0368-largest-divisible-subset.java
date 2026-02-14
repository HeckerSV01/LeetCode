class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int dp[] = new int[nums.length];
        int idx[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            idx[i] = i;
        }
        int maxlen = 1;
        int lastidx = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    idx[i] = j;
                }
            }
            if (dp[i] > maxlen) {
                maxlen = dp[i];
                lastidx = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (idx[lastidx] != lastidx) {
            res.add(nums[lastidx]);
            lastidx = idx[lastidx];
        }
        res.add(nums[lastidx]);
        return res;
    }
}