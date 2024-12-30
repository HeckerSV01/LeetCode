class Solution {
    public int reverse(int x) {
        int n=x;
        long ans=0;
        while(n!=0)
        {
            int k=n%10;
            ans=ans*10+k;
            n=n/10;
        }
        if(ans>Integer.MAX_VALUE||ans<Integer.MIN_VALUE)
        {
            return 0;
        }
        else
        return (int)ans;
    }
}