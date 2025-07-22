class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int left=0;
        int right=0;
        int sum=0;
        int maxsum=Integer.MIN_VALUE;
        while(right<nums.length)
        {
            if(!set.contains(nums[right]))
            {
                set.add(nums[right]);
                sum=sum+nums[right];
                maxsum=Math.max(maxsum,sum);
                right++;
            }
            else
            {
                set.remove(nums[left]);
                sum=sum-nums[left];
                left++;
            }
        }
        return maxsum;
    }
}