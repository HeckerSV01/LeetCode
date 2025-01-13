class Solution {
    public void sortColors(int[] nums) {
        int f[]=new int[3];
        for(int i=0;i<nums.length;i++)
        {
           int col=nums[i];
           f[col]++;
        }
        int i=0;
        int j=0;
        while(i<f.length)
        {
            int length=f[i]+j;
            while(j<length)
            {
                nums[j]=i;
                j++;
            }
            i++;
        }
    }
}