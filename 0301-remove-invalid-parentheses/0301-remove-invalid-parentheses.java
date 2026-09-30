class Solution {

    private void solve(String s, int i, StringBuilder sb,
                       int left, int right,
                       Set<String> set, int open) {

        if(i == s.length()){
            if(left == 0 && right == 0 && open == 0){
                set.add(sb.toString());
            }
            return;
        }

        if(s.charAt(i) == '('){

            // remove '('
            if(left > 0){
                solve(s, i + 1, sb, left - 1, right, set, open);
            }

            // keep '('
            sb.append('(');

            solve(s, i + 1, sb, left, right, set, open + 1);

            sb.deleteCharAt(sb.length() - 1);

        } else if(s.charAt(i) == ')'){

            // remove ')'
            if(right > 0){
                solve(s, i + 1, sb, left, right - 1, set, open);
            }

            // keep ')' only if matching '(' exists
            if(open > 0){

                sb.append(')');

                solve(s, i + 1, sb, left, right, set, open - 1);

                sb.deleteCharAt(sb.length() - 1);
            }

        } else {

            sb.append(s.charAt(i));

            solve(s, i + 1, sb, left, right, set, open);

            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> removeInvalidParentheses(String s) {

        int left = 0;
        int right = 0;

        for(char c : s.toCharArray()){

            if(c == '('){
                left++;
            }

            else if(c == ')'){

                if(left > 0){
                    left--;
                } else {
                    right++;
                }
            }
        }

        Set<String> set = new HashSet<>();

        solve(s, 0, new StringBuilder(),
              left, right, set, 0);

        return new ArrayList<>(set);
    }
}