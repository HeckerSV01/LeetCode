class Solution {
    public int searchInsert(int[] nums, int target) {
       int s=0;
       int e=nums.length-1;
        while(s<e)
        {
            int mid=(s+e)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(target<nums[mid])
            {
                e=mid-1;
            }
            else if(target>nums[mid])
            {
                s=mid+1;
            }
        }
        int i=0;
        int count=0;
        while(i<=nums.length-1)
        {
            if(target>nums[i])
            {
                count++;
            }
            i++;
        }
        return count;
    }
}