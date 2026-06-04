class Solution {
    private int calculate(int n)
    {
        String s=Integer.toString(n);
        int count=0;
        for(int i=1;i<s.length()-1;i++)
            {
                int prev=s.charAt(i-1)-'0';
                int next=s.charAt(i+1)-'0';
                int curr=s.charAt(i)-'0';
                if(curr>prev&&curr>next)
                {
                    count++;
                }
                if(curr<prev&&curr<next)
                {
                    count++;
                }
            }
        return count;
    }
    public int totalWaviness(int num1, int num2) {
        if(num1<100&&num2<100)
        {
            return 0;
        }
        if(num1<100)
        {
            num1=100;
        }
        int res=0;
        for(int i=num1;i<=num2;i++)
            {
                res=res+calculate(i);
            }
        return res;
    }
}