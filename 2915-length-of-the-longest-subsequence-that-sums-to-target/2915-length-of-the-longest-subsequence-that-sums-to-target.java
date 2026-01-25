class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int dp[][] = new int[nums.size()][target + 1];
        for (int i = 0; i < nums.size(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= target; i++) {
            if(nums.get(nums.size()-1)==i){
                dp[nums.size()-1][i]=1;
            } else {
                dp[nums.size()-1][i]=-1000000000;
            }
        }
        for (int i = nums.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= target; j++) {
                int notpick = dp[i + 1][j];
                int pick = -1000000000;
                if (j >= nums.get(i)) {
                    pick = 1 + dp[i + 1][j - nums.get(i)];
                }
                dp[i][j] = Math.max(notpick, pick);
            }
        }
        return (dp[0][target] < 0) ? -1 : dp[0][target];
    }
}