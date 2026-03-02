class Solution {
    public int lcs(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = s1.charAt(i - 1) + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public int minimumDeleteSum(String s1, String s2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            sum1 = sum1 + (s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            sum2 = sum2 + (s2.charAt(i));
        }
        int k = lcs(s1, s2);
        return sum1 - k + sum2 - k;
    }
}