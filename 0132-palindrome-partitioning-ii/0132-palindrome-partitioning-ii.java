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

    public int minCut(String s) {
        int dp[] = new int[s.length()+1];
        for (int i = dp.length - 2; i >= 0; i--) {
            String str = "";
            int min = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                str = s.substring(i, j + 1);
                if (ispalin(str)) {
                    int steps = 1 + dp[j + 1];
                    min = Math.min(min, steps);
                }
            }
            dp[i] = min;
        }
        return dp[0]-1;
    }
}