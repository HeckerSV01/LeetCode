class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int res = -1;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                boolean check = true;
                List<Integer> l = new ArrayList<>(map.values());
                int k = l.get(0);
                for (int m = 1; m < l.size(); m++) {
                    if (l.get(m) != k) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
}