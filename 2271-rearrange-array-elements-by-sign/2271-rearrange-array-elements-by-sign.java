class Solution {
    public int[] rearrangeArray(int[] nums) {
        int res[]=new int[nums.length];
        int p[]=new int[nums.length/2];
        int n[]=new int[nums.length/2];
        int j=0;
        int k=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                p[j++]=nums[i];
            }
            else
            {
                n[k++]=nums[i];
            }
        }
        j=k=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i%2==0)
            {
                res[i]=p[j++];
            }
            else
            {
                res[i]=n[k++];
            }
        }
        return res;
    }
}