class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2)
        {
            return 0;
        }
        Arrays.sort(nums);
        int max=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++)
        {
            max=Math.max(max,Math.abs(nums[i]-nums[i-1]));
        }
        return max;
    }
}