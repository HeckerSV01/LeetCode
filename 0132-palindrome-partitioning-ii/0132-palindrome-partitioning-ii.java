class Solution {
    private boolean ispalin(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private int cal(String s, int i, int dp[]) {
        if (i == s.length()) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        String str = "";
        int min = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            str = s.substring(i, j + 1);
            if (ispalin(str)) {
                int steps = 1 + cal(s, j + 1, dp);
                min = Math.min(min, steps);
            }
        }
        return dp[i] = min;
    }

    public int minCut(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return cal(s, 0, dp) - 1;
    }
}