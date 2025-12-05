class Solution {
    public int countPartitions(int[] nums) {
        int prefix[]=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            prefix[i]=nums[i]+prefix[i-1];
        }
        int count=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(prefix[i]%2==0&&(prefix[prefix.length-1]-prefix[i])%2==0)
            {
                count++;
            }
            if(prefix[i]%2!=0&&(prefix[prefix.length-1]-prefix[i])%2!=0)
            {
                count++;
            }
        }
        return count;
    }
}