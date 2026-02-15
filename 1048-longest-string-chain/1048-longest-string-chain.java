class Solution {
    private boolean check(String s1, String s2) {
        if (s1.length() + 1 != s2.length()) {
            return false;
        } else {
            int i1 = 0;
            int i2 = 0;
            while (i2 < s2.length()) {
                if (i1 < s1.length() && s1.charAt(i1) == s2.charAt(i2)) {
                    i1++;
                    i2++;
                } else {
                    i2++;
                }
            }
            return i1 == s1.length();
        }
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int dp[] = new int[words.length];
        Arrays.fill(dp, 1);
        int maxlen = 1;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (check(words[j], words[i]) && dp[j] + 1 > dp[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            if (dp[i] > maxlen) {
                maxlen = dp[i];
            }
        }
        int res = 0;
        for (int k : dp) {
            res = Math.max(res, k);
        }
        return res;
    }
}