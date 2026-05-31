class Solution {
    public long countSubarrays(int[] nums, long k) {
        int l=0;
        int r=0;
        long sum=0;
        long res=0;
        while(r<nums.length){
            sum=sum+nums[r];
            while(sum*(r-l+1)>=k){
                sum=sum-nums[l];
                l++;
            }
            res=res+r-l+1;
            r++;
        }
        return res;
    }
}