class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
            }
        }
        if(max<0)
        {
            return 1;
        }
        int res=0;
        int j;
        for(j=1;j<=max;j++)
        {
            if(!set.contains(j))
            {
                return j;
            }
        }
        return max+1;
    }
}