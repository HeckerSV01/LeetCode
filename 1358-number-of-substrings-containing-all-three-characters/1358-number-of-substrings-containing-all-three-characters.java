class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0;
        int r = 0;
        int res = 0;
        int freq[] = new int[3];
        while (r < s.length()) {
            freq[s.charAt(r) - 'a']++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                    res = res + s.length() - r;
                }
                char c = s.charAt(l);
                freq[c - 'a']--;
                l++;
            }
            r++;
        }
        return res;
    }
}