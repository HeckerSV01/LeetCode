class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder  sb=new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            char c=sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
            if(sb.toString().equals(goal)){
                return true;
            }
        }
        return false;
    }
}