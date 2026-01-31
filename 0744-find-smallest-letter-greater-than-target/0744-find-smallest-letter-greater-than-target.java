class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        boolean check = false;
        char res = letters[0];
        for (char c : letters) {
            if ((int) c > (int) target) {
                res = c;
                break;
            }
        }
        return res;
    }
}