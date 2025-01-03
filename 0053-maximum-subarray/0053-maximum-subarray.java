class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = Integer.MIN_VALUE;
        int currsum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            currsum+=nums[i];
            maxsum=Math.max(maxsum,currsum);
            if(currsum<0)
            {
                currsum=0;
            }
        }
        return maxsum;
    }
}