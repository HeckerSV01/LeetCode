class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int sufmax[]=new int[nums.length];
        sufmax[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            sufmax[i]=Math.max(nums[i],sufmax[i+1]);
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<=nums.length-k-1;i++){
            res=Math.max(res,nums[i]+sufmax[i+k]);
        }
        return res;
    }
}