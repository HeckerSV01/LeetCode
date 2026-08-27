class Solution {
    private char greater(TreeMap<Character, Integer> map, char cur) {
        char smallestgreater = '\u0000';
        for (char c : map.keySet()) {
            if (c > cur) {
                smallestgreater = c;
                break;
            }
        }
        return smallestgreater;
    }

    private String buildrest(TreeMap<Character, Integer> map) {
        StringBuilder res = new StringBuilder();
        for (char c : map.keySet()) {
            for (int i = 0; i < map.get(c); i++) {
                res.append(c);
            }
        }
        return res.toString();
    }

    public String lexGreaterPermutation(String s, String target) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = target.charAt(i);
            if (map.containsKey(cur)) {
                res.append(cur);
                if (map.get(cur) == 1) {
                    map.remove(cur);
                } else {
                    map.put(cur, map.get(cur) - 1);
                }
            } else {
                char smallestgreater = greater(map, cur);
                if (smallestgreater != '\u0000') {
                    res.append(smallestgreater);
                    if (map.get(smallestgreater) == 1) {
                        map.remove(smallestgreater);
                    } else {
                        map.put(smallestgreater, map.get(smallestgreater) - 1);
                    }
                    return res.toString() + buildrest(map);
                }
                break;
            }
        }
        for (int j = res.length() - 1; j >= 0; j--) {
            char curr = res.charAt(j);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            char smallestgreater = greater(map, target.charAt(j));
            if (smallestgreater != '\u0000') {
                res.setLength(j);
                res.append(smallestgreater);
                if (map.get(smallestgreater) == 1) {
                    map.remove(smallestgreater);
                } else {
                    map.put(smallestgreater, map.get(smallestgreater) - 1);
                }
                return res.toString() + buildrest(map);
            }
        }
        return "";
    }
}