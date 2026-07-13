class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int curlen = 0;
            int startidx = i;
            int letters = 0;
            while (curlen < maxWidth) {
                curlen = curlen + words[i].length();
                letters = letters + words[i].length();
                if (i < words.length - 1 && curlen + words[i + 1].length() + 1 <= maxWidth) {
                    curlen++;
                    i++;
                } else {
                    break;
                }
            }
            int gaps = i - startidx;
            int spaces = maxWidth - letters;
            StringBuilder sb = new StringBuilder();
            if (i == words.length - 1 || gaps == 0) {
                for (int j = startidx; j <= i; j++) {
                    sb.append(words[j]);
                    if (j != i)
                        sb.append(" ");
                }
                while (sb.length() < maxWidth)
                    sb.append(" ");
            } else {
                int s1 = spaces / gaps;
                int s2 = spaces % gaps;
                int l = 0;
                for (int j = startidx; j <= i; j++) {
                    sb.append(words[j]);
                    if (j != i) {
                        int cnt = s1;
                        if (l < s2)
                            cnt++;
                        for (int k = 0; k < cnt; k++)
                            sb.append(" ");
                        l++;
                    }
                }
            }

            res.add(sb.toString());
            i++;
        }
        return res;
    }
}