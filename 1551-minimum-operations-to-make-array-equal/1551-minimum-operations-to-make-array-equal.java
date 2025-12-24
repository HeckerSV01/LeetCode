class Solution {
    public int minOperations(int n) {
        int res=0;
        int mean=(1+(2*(n-1)+1))/2;
        for(int i=0;i<n/2;i++)
        {
            res=res+mean-((2*i)+1);
        }
        return res;
    }
}