class Solution {
    private boolean cal(int a[], int idx, int target, int dp[][]) {
        if(target == 0) {
            return true;
        }
        if(idx == 0) {
            return a[0] == target;
        }
        if(dp[idx][target] != -1) {
            return dp[idx][target] == 1;
        }
        boolean nottake = cal(a, idx - 1, target, dp);
        boolean take = false;
        if(a[idx] <= target) {
            take = cal(a, idx - 1, target - a[idx], dp);
        }
        if(nottake || take) {
            dp[idx][target] = 1;
        } else {
            dp[idx][target] = 0;
        }
        return nottake || take;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if(sum % 2 != 0) {
            return false;
        } else {
            int target = sum / 2;
            int dp[][] = new int[nums.length][target + 1];
            for(int i = 0; i < nums.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            return cal(nums, nums.length - 1, target, dp);
        }
    }
}