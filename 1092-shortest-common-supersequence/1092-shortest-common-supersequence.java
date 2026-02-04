class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = str1.length();
        int j = str2.length();
        StringBuilder res = new StringBuilder();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                res.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                res.append(str1.charAt(i - 1));
                i--;
            } else {
                res.append(str2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            res.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            res.append(str2.charAt(j - 1));
            j--;
        }
        return res.reverse().toString();
    }
}