class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1){
            return 0;
        }
        int l=0;
        int r=0;
        int prod=1;
        int res=0;
        while(r<nums.length){
            prod=prod*nums[r];
            while(prod>=k){
                prod=prod/nums[l];
                l++;
            }
            res=res+r-l+1;
            r++;
        }
        return res;
    }
}