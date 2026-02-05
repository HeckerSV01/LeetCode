class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int len = nums.length;
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int k = Math.abs(nums[i]) % len;
            if (nums[i] >= 0) {
                int m = (i + k) % len;
                res[i] = nums[m];
            } else {
                int m = (i - k) % len;
                if (m < 0) {
                    m = len + m;
                }
                res[i] = nums[m];
            }
        }
        return res;
    }
}