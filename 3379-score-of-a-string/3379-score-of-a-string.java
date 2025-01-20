class Solution {
    public int scoreOfString(String s) {
        int abssum=0;
       for(int i=1;i<s.length();i++)
       {
         abssum+=Math.abs(((int)s.charAt(i)-(int)s.charAt(i-1)));
       } 
       return abssum;
    }
}