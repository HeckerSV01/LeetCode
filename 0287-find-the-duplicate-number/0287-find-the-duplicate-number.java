class Solution {
    public int findDuplicate(int[] nums) {
        int k=Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++)
       {
        if(k<nums[i])
        {
            k=nums[i];
        }
       }
       int a[]=new int[k+1];
       for(int i=0;i<a.length;i++)
       {
        a[nums[i]]++;
       }
       for(int i=0;i<a.length;i++)
       {
        if(a[i]>1)
        {
            return i;
        }
       }
       return 0;
    }
}