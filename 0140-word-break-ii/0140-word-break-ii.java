class Solution {
    private List<String> cal(String s, HashSet<String> set, int i, HashMap<Integer, List<String>> dp) {
        List<String> list = new ArrayList<>();
        if (i == s.length()) {
            list.add("");
            return list;
        }
        if (dp.get(i) != null) {
            return dp.get(i);
        }
        for (int j = i; j < s.length(); j++) {
            String str = s.substring(i, j + 1);
            if (set.contains(str)) {
                List<String> l = cal(s, set, j + 1, dp);
                for (String k : l) {
                    if (k == "") {
                        list.add(str);
                    } else {
                        list.add(str + " " + k);
                    }
                }
            }
        }
        dp.put(i, list);
        return list;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        HashMap<Integer, List<String>> dp = new HashMap<>();
        return cal(s, set, 0, dp);
    }
}