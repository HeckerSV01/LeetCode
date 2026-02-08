class Solution {
    private int cal(String s1, String s2, int i, int j, int dp[][]) {
        if (i < 0 && j < 0) {
            return 1;
        } else if (i < 0 && j >= 0) {
            int check = 1;
            for (int k = 0; k <= j; k++) {
                if (s2.charAt(k) != '*') {
                    check = 0;
                    break;
                }
            }
            return check;
        } else if (i >= 0 && j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '?') {
            return dp[i][j] = cal(s1, s2, i - 1, j - 1, dp);
        } else if (s2.charAt(j) == '*') {
            int nottake = cal(s1, s2, i, j - 1, dp);
            int take = cal(s1, s2, i - 1, j, dp);
            return dp[i][j] = (nottake == 1 || take == 1) ? 1 : 0;
        } else {
            return dp[i][j] = 0;
        }
    }

    public boolean isMatch(String s, String p) {
        int dp[][] = new int[s.length()][p.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return (cal(s, p, s.length() - 1, p.length() - 1, dp) == 1) ? true : false;
    }
}