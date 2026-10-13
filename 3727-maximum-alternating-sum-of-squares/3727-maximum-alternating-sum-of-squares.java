class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long sq[]=new long[n];
        for(int i=0;i<n;i++)
            {
                sq[i]=nums[i]*nums[i];
            }
        long res=0;
        Arrays.sort(sq);
        int idx=(n+1)/2;
        for(int i=n-1;i>=n-idx;i--)
            {
                res=res+sq[i];
            }
        for(int i=0;i<n-idx;i++)
            {
                res=res-sq[i];
            }
        return res;
    }
}