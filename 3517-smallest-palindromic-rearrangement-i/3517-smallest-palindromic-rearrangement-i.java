class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        String res="";
        if(n==1){
            return s;
        }
        if(n%2==0){
            String s1=s.substring(0,n/2);
            char c1[]=s1.toCharArray();
            Arrays.sort(c1);
            String k=new String(c1);
            StringBuilder sb=new StringBuilder(k);
            s1=sb.toString();
            String rev=sb.reverse().toString();
            res=res+s1+rev;
        }else{
            String s1=s.substring(0,n/2);
            char c1[]=s1.toCharArray();
            Arrays.sort(c1);
            String k=new String(c1);
            StringBuilder sb=new StringBuilder(k);
            s1=sb.toString();
            String rev=sb.reverse().toString();
            res=res+s1+s.charAt(n/2)+rev;
        }
        return res;
    }
}