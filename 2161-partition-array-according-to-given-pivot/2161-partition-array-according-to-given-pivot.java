class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int res[]=new int[nums.length];
        int idx=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<pivot)
            {
                res[idx]=nums[i];
                idx++;
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==pivot)
            {
                res[idx]=nums[i];
                idx++;
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>pivot)
            {
                res[idx]=nums[i];
                idx++;
            }
        }
        return res;
    }
}