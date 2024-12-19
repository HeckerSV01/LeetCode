class Solution {
    public boolean isPalindrome(int x) {
        int n=x;
        int sum=0;
        int k;
        if(x<0)
        {
            return false;
        }
        else 
        {
            while(n!=0)
            {
             k=n%10;
               sum=sum*10+k;
               n=n/10;
            }
            return sum==x;
         }
    }
}