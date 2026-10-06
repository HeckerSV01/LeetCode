class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder res=new StringBuilder(s.length() + spaces.length);
        int idx=0;
        for(int i=0;i<s.length();i++){
            if(idx<spaces.length&&i==spaces[idx]){
                res.append(" ");
                idx++;
            }
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}