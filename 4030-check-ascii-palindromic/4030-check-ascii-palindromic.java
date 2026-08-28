class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            String bin=Integer.toBinaryString((int)c);
            bin="0"+bin;
            sb.append(bin);
        }
        for(int i=0;i<sb.length()/2;i++){
            if(sb.charAt(i)!=sb.charAt(sb.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}