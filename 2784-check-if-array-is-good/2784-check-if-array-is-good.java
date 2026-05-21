class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n = nums[nums.length - 1];
        if (nums.length != n + 1) {
            return false;
        }
        int[] freq = new int[n + 1];
        for (int num : nums) {
            if (num <= 0 || num > n) return false;
            freq[num]++;
        }
        for (int i = 1; i < n; i++) {
            if (freq[i] != 1) return false;
        }
        return freq[n] == 2;
    }
}
