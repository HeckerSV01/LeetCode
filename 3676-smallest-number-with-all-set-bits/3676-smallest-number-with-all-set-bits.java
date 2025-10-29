class Solution {
    public int smallestNumber(int n) {
        for(int i=1;;i++)
        {
            if(Math.pow(2,i)-1>=n)
            {
                return (int)Math.pow(2,i)-1;
            }
        }
    }
}