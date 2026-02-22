class Solution {
    private boolean cal(String s, List<String> dict, int i, Boolean dp[]) {
        if (i == s.length()) {
            return true;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        boolean res = false;
        for (int j = 0; j < dict.size(); j++) {
            String str = dict.get(j);
            if (i + str.length() <= s.length() && s.substring(i, i + str.length()).equals(str)) {
                res = res||cal(s, dict, i + str.length(), dp);
            }
        }
        return dp[i] = res;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean dp[] = new Boolean[s.length()];
        return cal(s, wordDict, 0, dp);
    }
}