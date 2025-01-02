
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==0||num==1)
        {
            return true;
        }
        long st=2;
        long en=num/2;
        while(st<=en)
        {
            long mid=(st+en)/2;
            if((mid*mid)==(long)(num))
            {
                return true;
            }
            else if(mid*mid>num)
            {
                en=mid-1;
            }
            else
            {
                st=mid+1;
            }
        }
        return false;
    }
}