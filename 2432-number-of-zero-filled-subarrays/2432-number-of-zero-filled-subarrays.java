class Solution {
    public long zeroFilledSubarray(int[] nums) {
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                int count=1;
                while(i<nums.length-1&&nums[i+1]==0)
                {
                    count++;
                    i++;
                }
                l.add(count);
            }
        }
        long res=0;
        for(int i:l)
        {
            res=res+(long)i*(i+1)/2;
        }
        return res;
    }
}