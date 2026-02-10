class Solution {
    public int longestBalanced(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> odd = new HashSet<>();
            HashSet<Integer> even = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 0) {
                    even.add(nums[j]);
                } else {
                    odd.add(nums[j]);
                }
                if (even.size() == odd.size()) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
}