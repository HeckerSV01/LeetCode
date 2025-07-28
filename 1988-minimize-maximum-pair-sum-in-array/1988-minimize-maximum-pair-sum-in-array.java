class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        int min=Integer.MIN_VALUE;
        while(left<right)
        {
            min=Math.max(min,nums[left]+nums[right]);
            left++;
            right--;
        }
        return min;
    }
}