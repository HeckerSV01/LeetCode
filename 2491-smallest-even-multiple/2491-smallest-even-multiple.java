class Solution {
    public int smallestEvenMultiple(int n) {
        int k=0;
        for(int i=n;i>0;i++)
        {
            if(i%2==0&&i%n==0)
            {
                k=i;
                break;
            }
        }
        return k;
    }
}