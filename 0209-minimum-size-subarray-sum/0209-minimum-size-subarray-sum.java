class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minlen=Integer.MAX_VALUE;
        int left=0;
        int right=0;
        int sum=0;
        while(right<nums.length)
        {
            sum=sum+nums[right];
            while(sum>=target)
            {
                minlen=Math.min(minlen,right-left+1);
                sum=sum-nums[left];
                left++;
            }
            right++;
        }
        return (minlen==Integer.MAX_VALUE)?0:minlen;
    }
}