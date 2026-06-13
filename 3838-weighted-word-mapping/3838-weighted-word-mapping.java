class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            int sum = 0;

            for (int j = 0; j < words[i].length(); j++) {
                sum += weights[words[i].charAt(j) - 'a'];
            }

            int mod = sum % 26;
            res.append((char) ('z' - mod));
        }

        return res.toString();
    }
}
