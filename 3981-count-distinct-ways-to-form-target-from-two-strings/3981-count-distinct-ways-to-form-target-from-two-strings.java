class Solution {
    final int MOD = 1000000007;

    private int solve(String s1, String s2, String target, int i, int j, int k, Integer dp[][][]) {
        if (k == target.length()) {
            if (i > 0 && j > 0) {
                return 1;
            }
            return 0;
        }
        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }
        int res = 0;
        for (int a = i; a < s1.length(); a++) {
            if (s1.charAt(a) == target.charAt(k)) {
                res = (res + solve(s1, s2, target, a + 1, j, k + 1, dp)) % MOD;
            }
        }
        for (int a = j; a < s2.length(); a++) {
            if (s2.charAt(a) == target.charAt(k)) {
                res = (res + solve(s1, s2, target, i, a + 1, k + 1, dp)) % MOD;
            }
        }
        return dp[i][j][k] = res;
    }

    public int interleaveCharacters(String word1, String word2, String target) {
        Integer dp[][][] = new Integer[101][101][101];
        return solve(word1, word2, target, 0, 0, 0, dp);
    }
}