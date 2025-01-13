class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
           if(Character.isLetterOrDigit(s.charAt(i)))
           {
            sb.append(Character.toLowerCase(s.charAt(i)));
           }
        }
        String str=sb.toString();
        String strrev=sb.reverse().toString();
        return strrev.equals(str);
    }
}