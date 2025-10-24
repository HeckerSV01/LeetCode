class Solution {
    public boolean check(int n)
    {
        int k=n;
        int freq[]=new int[10];
        while(k!=0)
        {
            int t=k%10;
            freq[t]++;
            k=k/10;
        }
        for(int i=0;i<10;i++)
        {
            if(freq[i]!=0&&freq[i]!=i)
            {
                return false;
            }
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        int k=n+1;
        while(true)
        {
            if(check(k))
            {
                return k;
            }
            k++;
        }
    }
}