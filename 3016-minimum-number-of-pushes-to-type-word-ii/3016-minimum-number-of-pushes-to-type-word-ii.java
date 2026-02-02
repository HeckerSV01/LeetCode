class Solution {
    public int minimumPushes(String word) {
        int a[] = new int[26];
        for (char c : word.toCharArray()) {
            a[(int) c - 97]++;
        }
        Arrays.sort(a);
        int i = 25;
        int res = 0;
        int count = 0;
        int push = 1;
        while (i >= 0 && a[i] > 0) {
            if (count == 8) {
                push++;
                count = 0;
            }
            res = res + a[i] * push;
            count++;
            i--;
        }
        return res;
    }
}