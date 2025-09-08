class Solution {
    public boolean check(int n)
    {
        String s=String.valueOf(n);
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
            {
                return false;
            }
        }
        return true;
    }
    public int[] getNoZeroIntegers(int n) {
        int res[]=new int[2];
        for(int i=1;i<n;i++)
        {
            if(check(i))
            {
                if(check(n-i))
                {
                    res[0]=i;
                    res[1]=n-i;
                    break;
                }
                else
                {
                    continue;
                }
            }
        }
        return res;
    }
}