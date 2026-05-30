class Solution {
    public int longestSubarray(int[] nums) {
        int zero=0;
        int l=0;
        int r=0;
        int res=-1;
        while(r<nums.length){
            if(nums[r]==0){
                zero++;
            }
            while(zero>1){
                if(nums[l]==0){
                    zero--;
                }
                l++;
            }
            res=Math.max(res,r-l+1);
            r++;
        }
        return res-1;
    }
}