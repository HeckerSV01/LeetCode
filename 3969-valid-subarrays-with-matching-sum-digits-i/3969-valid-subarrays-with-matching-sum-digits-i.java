class Solution {
    private boolean check(long num, int x) {
        long last = num % 10;
        long first = num;
        while (first >= 10) {
            first = first / 10;
        }
        return (first == x) && (last == x);
    }

    public int countValidSubarrays(int[] nums, int x) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (check(sum, x)) {
                    count++;
                }
            }
        }
        return count;
    }
}