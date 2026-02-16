class Solution {
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        sb.reverse();
        int rem = 32 - sb.length();
        for (int i = 0; i < rem; i++) {
            sb.append('0');
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}