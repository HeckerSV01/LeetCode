class Solution {
    public int removeDuplicates(int[] nums) {
        int idx=0;
        for(int i=0;i<nums.length;i++)
        {
            int count=1;
            while(i<nums.length-1&&nums[i]==nums[i+1])
            {
                i++;
                if(count<2)
                {
                    count++;
                }
            }
            for(int j=0;j<count;j++)
                {
                    nums[idx]=nums[i];
                    idx++;
                }
        }
        return idx;
    }
}