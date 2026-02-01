class Solution {
    public int minimumCost(int[] nums) {
        int res = nums[0];
        int minidx1 = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minidx1) {
                minidx1 = nums[i];
                idx = i;
            }
        }
        int minidx2 = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (i == idx) {
                continue;
            }
            if (nums[i] < minidx2) {
                minidx2 = nums[i];
            }
        }
        return res + minidx1 + minidx2;
    }
}