class Solution {
    public int f(int[] nums) {
        if(nums.length==1)
        {
            return nums[0];
        }
        if(nums.length==2)
        {
            return Math.max(nums[0],nums[1]);
        }
        int dp[]=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++)
        {
            int a=nums[i]+dp[i-2];
            int b=0+dp[i-1];
            dp[i]=Math.max(a,b);
        }
        return dp[dp.length-1];
    }
    public int rob(int[] nums) {
        if(nums.length==1)
        {
            return nums[0];
        }
        if(nums.length==2)
        {
            return Math.max(nums[0],nums[1]);
        }
        int a1[]=new int[nums.length-1];
        int a2[]=new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++)
        {
            a1[i]=nums[i];
            a2[i]=nums[i+1];
        }
        return Math.max(f(a1),f(a2));
    }
}