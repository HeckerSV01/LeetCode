class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        int sum = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            sum = carry;
            if (i >= 0) {
                sum = sum + a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum = sum + b.charAt(j) - '0';
                j--;
            }
            res.append(sum % 2);
            carry = sum / 2;
        }
        return res.reverse().toString();
    }
}