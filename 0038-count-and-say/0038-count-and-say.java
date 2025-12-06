class Solution {
    public String cal(String s)
    {
        String st="";
        int count=1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                count++;
            }
            else
            {
                st=st+count+s.charAt(i-1);
                count=1;
            }
        }
        st=st+count+s.charAt(s.length()-1);
        return st;
    }
    public String countAndSay(int n) {
        String s="1";
        if(n==1)
        {
            return s;
        }
        for(int i=1;i<n;i++)
        {
            s=cal(s);
        }
        return s;
    }
}