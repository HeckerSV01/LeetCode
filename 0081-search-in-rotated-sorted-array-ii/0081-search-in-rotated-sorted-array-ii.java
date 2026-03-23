class Solution {
    public boolean search(int[] nums, int target) {
        int st=0;
        int en=nums.length-1;
        while(st<=en)
        {
            int mid=st+(en-st)/2;
            if(nums[mid]==target)
            {
                return true;
            }
            if(nums[mid]==nums[st]&&nums[mid]==nums[en]){
                st++;
                en--;
            }
            else if(nums[mid]>=nums[st])
            {
                if(nums[st]<=target&&target<=nums[mid])
                {
                    en=mid-1;
                }
                else
                {
                    st=mid+1;
                }
            }
            else
            {
                if(nums[mid]<=target&& target<=nums[en])
                {
                    st=mid+1;
                }
                else
                {
                    en=mid-1;
                }
            }
        }
        return false;
    }
}