class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero=0;
        int l=0;
        int r=0;
        int res=-1;
        for(r=0;r<nums.length;r++){
            if(nums[r]==0){
                zero++;
            }
            if(zero>k){
                if(nums[l]==0){
                    zero--;
                }
               l++;
            }
            if(zero<=k){
                res=Math.max(res,r-l+1);
            }
        }
        return res;
    }
}