class Solution {
    private boolean isPalin(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public int maxPalindromes(String s, int k) {
        int res = 0;
        int end = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int m : new int[] { i - 1, i }) {
                int l = m;
                int r = i;
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 >= k && l > end) {
                        res++;
                        end = r;
                        break;
                    }
                    l--;
                    r++;
                }
            }
        }
        return res;
    }
}