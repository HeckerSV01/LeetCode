class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int ans[]=new int[2];
        while(left<right)
        {
            if(nums[left]+nums[right]<target)
            {
                left++;
            }
            else if(nums[left]+nums[right]>target)
            {
                right--;
            }
            else
            {
                ans[0]=left+1;
                ans[1]=right+1;
                break;
            }
        }
        return ans; 
    }
}