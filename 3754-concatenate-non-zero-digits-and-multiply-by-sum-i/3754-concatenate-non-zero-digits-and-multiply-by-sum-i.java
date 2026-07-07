class Solution {
    public long sumAndMultiply(int n) {
        long res=0;
        String s=Integer.toString(n);
        long sum=0;
        for(int i=0;i<s.length();i++)
            {
                sum=sum+s.charAt(i)-'0';
            }
        String num="0";
        for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)!='0')
                {
                    num=num+s.charAt(i);
                }
            }
        return (long)Integer.parseInt(num)*sum;
    }
}