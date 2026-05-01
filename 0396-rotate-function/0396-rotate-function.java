class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum=0;
        int f0=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            f0=f0+i*nums[i];
        }
        int res=f0;
        for(int i=1;i<nums.length;i++){
            int k=f0-((nums.length-1)*nums[nums.length-i])+(sum-nums[nums.length-i]);
            res=Math.max(k,res);
            f0=k;
        }
        return res;
    }
}